/**
 * Copyright (c) 2019 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Geoprism Registry(tm).
 *
 * Geoprism Registry(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Geoprism Registry(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Geoprism Registry(tm). If not, see <http://www.gnu.org/licenses/>.
 */
package net.geoprism.registry;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.commongeoregistry.adapter.dataaccess.LocalizedValue;
import org.commongeoregistry.adapter.metadata.AttributeType;
import org.commongeoregistry.adapter.metadata.GeoObjectType;
import org.commongeoregistry.adapter.metadata.HierarchyType;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.runwaysdk.Pair;
import com.runwaysdk.dataaccess.ProgrammingErrorException;
import com.runwaysdk.dataaccess.metadata.SupportedLocaleDAO;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.session.Session;
import com.runwaysdk.system.gis.geo.Universal;

import net.geoprism.GeoprismProperties;
import net.geoprism.registry.conversion.LocalizedValueConverter;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.graph.VertexServerGeoObject;
import net.geoprism.registry.service.LocaleSerializer;
import net.geoprism.registry.service.ServiceFactory;

public class MasterList extends MasterListBase
{
  private static final long  serialVersionUID = 190790165;

  public static final String LEAF             = "leaf";

  public static final String TYPE_CODE        = "typeCode";

  public static final String ATTRIBUTES       = "attributes";

  public static final String NAME             = "name";

  public static final String LABEL            = "label";

  public static final String VALUE            = "value";

  public static final String TYPE             = "type";

  public static final String BASE             = "base";

  public static final String DEPENDENCY       = "dependency";

  public static final String DEFAULT_LOCALE   = "DefaultLocale";

  public static final String VERSIONS         = "versions";

  public MasterList()
  {
    super();
  }

  @Override
  @Transaction
  public void apply()
  {
    if (!isValidName(this.getCode()))
    {
      throw new InvalidMasterListCodeException("The master list code has an invalid character");
    }

    super.apply();
  }

  @Override
  @Transaction
  public void delete()
  {
    List<MasterListVersion> versions = this.getVersions();

    for (MasterListVersion version : versions)
    {
      version.delete();
    }

    super.delete();

    final File directory = this.getShapefileDirectory();

    if (directory.exists())
    {
      try
      {
        FileUtils.deleteDirectory(directory);
      }
      catch (IOException e)
      {
        throw new ProgrammingErrorException(e);
      }
    }
  }

  public File getShapefileDirectory()
  {
    final File root = GeoprismProperties.getGeoprismFileStorage();
    final File directory = new File(root, "shapefiles");

    return new File(directory, this.getOid());
  }

  public List<MasterListVersion> getVersions()
  {
    MasterListVersionQuery query = new MasterListVersionQuery(new QueryFactory());
    query.WHERE(query.getMasterlist().EQ(this));

    try (OIterator<? extends MasterListVersion> it = query.getIterator())
    {
      return new LinkedList<MasterListVersion>(it.getAll());
    }
  }

  public JsonArray getHierarchiesAsJson()
  {
    if (this.getHierarchies() != null && this.getHierarchies().length() > 0)
    {
      return new JsonParser().parse(this.getHierarchies()).getAsJsonArray();
    }

    return new JsonArray();
  }

  public Map<HierarchyType, List<GeoObjectType>> getAncestorMap(ServerGeoObjectType type)
  {
    Map<HierarchyType, List<GeoObjectType>> map = new HashMap<>();

    JsonArray hierarchies = this.getHierarchiesAsJson();

    for (int i = 0; i < hierarchies.size(); i++)
    {
      JsonObject hierarchy = hierarchies.get(i).getAsJsonObject();

      List<String> pCodes = this.getParentCodes(hierarchy);

      if (pCodes.size() > 0)
      {
        String hCode = hierarchy.get("code").getAsString();
        HierarchyType hierarchyType = ServiceFactory.getAdapter().getMetadataCache().getHierachyType(hCode).get();

        map.put(hierarchyType, ServiceFactory.getUtilities().getAncestors(type, hCode));
      }
    }

    return map;
  }

  public List<String> getParentCodes(JsonObject hierarchy)
  {
    List<String> list = new LinkedList<String>();

    JsonArray parents = hierarchy.get("parents").getAsJsonArray();

    for (int i = 0; i < parents.size(); i++)
    {
      JsonObject parent = parents.get(i).getAsJsonObject();

      if (parent.has("selected") && parent.get("selected").getAsBoolean())
      {
        list.add(parent.get("code").getAsString());
      }
    }

    return list;
  }

  public List<Date> getFrequencyDates(Date startDate, Date endDate)
  {
    LinkedList<Date> dates = new LinkedList<Date>();

    List<ChangeFrequency> frequencies = this.getFrequency();

    if (frequencies.contains(ChangeFrequency.ANNUAL))
    {
      Calendar end = getEndOfYear(endDate);
      Calendar calendar = getEndOfYear(startDate);

      while (calendar.before(end) || calendar.equals(end))
      {
        dates.add(calendar.getTime());

        calendar.add(Calendar.YEAR, 1);
      }
    }
    else if (frequencies.contains(ChangeFrequency.QUARTER))
    {
      Calendar end = getEndOfQuarter(endDate);
      Calendar calendar = getEndOfQuarter(startDate);

      while (calendar.before(end) || calendar.equals(end))
      {
        dates.add(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        this.moveToEndOfQuarter(calendar);
      }
    }
    else if (frequencies.contains(ChangeFrequency.MONTHLY))
    {
      Calendar end = getEndOfMonth(endDate);
      Calendar calendar = getEndOfMonth(startDate);

      while (calendar.before(end) || calendar.equals(end))
      {
        dates.add(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        this.moveToEndOfMonth(calendar);
      }
    }
    else
    {
      throw new UnsupportedOperationException();
    }

    return dates;
  }

  private Calendar getEndOfYear(Date date)
  {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.setTime(date);
    calendar.set(Calendar.MONTH, Calendar.DECEMBER);
    calendar.set(Calendar.DAY_OF_MONTH, 31);

    return calendar;
  }

  private Calendar getEndOfQuarter(Date date)
  {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.setTime(date);

    moveToEndOfQuarter(calendar);

    return calendar;
  }

  private Calendar getEndOfMonth(Date date)
  {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.setTime(date);

    moveToEndOfMonth(calendar);

    return calendar;
  }

  private void moveToEndOfMonth(Calendar calendar)
  {
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
  }

  private void moveToEndOfQuarter(Calendar calendar)
  {
    int quarter = ( calendar.get(Calendar.MONTH) / 3 ) + 1;
    int month = ( quarter * 3 ) - 1;

    calendar.set(Calendar.MONTH, month);
    moveToEndOfMonth(calendar);
  }

  public ChangeFrequency toFrequency()
  {
    if (this.getFrequency().size() > 0)
    {
      return this.getFrequency().get(0);
    }

    return ChangeFrequency.ANNUAL;
  }

  public JsonObject toJSON()
  {
    return this.toJSON(false);
  }

  public JsonObject toJSON(boolean includeVersions)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    Locale locale = Session.getCurrentLocale();
    LocaleSerializer serializer = new LocaleSerializer(locale);

    ServerGeoObjectType type = ServerGeoObjectType.get(this.getUniversal());

    JsonObject object = new JsonObject();

    if (this.isAppliedToDB())
    {
      object.addProperty(MasterList.OID, this.getOid());
    }

    object.addProperty(MasterList.TYPE_CODE, type.getCode());
    object.addProperty(MasterList.LEAF, type.isLeaf());
    object.add(MasterList.DISPLAYLABEL, LocalizedValueConverter.convert(this.getDisplayLabel()).toJSON(serializer));
    object.addProperty(MasterList.CODE, this.getCode());
    object.addProperty(MasterList.LISTABSTRACT, this.getListAbstract());
    object.addProperty(MasterList.PROCESS, this.getProcess());
    object.addProperty(MasterList.PROGRESS, this.getProgress());
    object.addProperty(MasterList.ACCESSCONSTRAINTS, this.getAccessConstraints());
    object.addProperty(MasterList.USECONSTRAINTS, this.getUseConstraints());
    object.addProperty(MasterList.ACKNOWLEDGEMENTS, this.getAcknowledgements());
    object.addProperty(MasterList.DISCLAIMER, this.getDisclaimer());
    object.addProperty(MasterList.CONTACTNAME, this.getContactName());
    object.addProperty(MasterList.ORGANIZATION, this.getOrganization());
    object.addProperty(MasterList.TELEPHONENUMBER, this.getTelephoneNumber());
    object.addProperty(MasterList.EMAIL, this.getEmail());
    object.addProperty(MasterList.FREQUENCY, this.toFrequency().name());
    object.add(MasterList.HIERARCHIES, this.getHierarchiesAsJson());

    if (this.getRepresentativityDate() != null)
    {
      object.addProperty(MasterList.REPRESENTATIVITYDATE, format.format(this.getRepresentativityDate()));
    }

    if (this.getPublishDate() != null)
    {
      object.addProperty(MasterList.PUBLISHDATE, format.format(this.getPublishDate()));
    }

    if (includeVersions)
    {
      List<MasterListVersion> versions = this.getVersions();

      JsonArray jVersions = new JsonArray();

      for (MasterListVersion version : versions)
      {
        jVersions.add(version.toJSON(false));
      }

      object.add(MasterList.VERSIONS, jVersions);
    }

    return object;
  }

  private void createMdAttributeFromAttributeType(ServerGeoObjectType type, AttributeType attributeType, List<Locale> locales)
  {
    List<MasterListVersion> versions = this.getVersions();

    for (MasterListVersion version : versions)
    {
      version.createMdAttributeFromAttributeType(type, attributeType, locales);
    }
  }

  private void removeAttributeType(AttributeType attributeType)
  {
    List<MasterListVersion> versions = this.getVersions();

    for (MasterListVersion version : versions)
    {
      version.removeAttributeType(attributeType);
    }
  }

  @Transaction
  public MasterListVersion createVersion(Date forDate, String versionType)
  {
    // MasterListVersionQuery query = new MasterListVersionQuery(new
    // QueryFactory());
    // query.WHERE(query.getMasterlist().EQ(this));
    // query.AND(query.getForDate().EQ(forDate));
    //
    // try (OIterator<? extends MasterListVersion> it = query.getIterator())
    // {
    // if (it.hasNext())
    // {
    // return it.next();
    // }
    // }

    return MasterListVersion.create(this, forDate, versionType);
  }

  @Transaction
  public MasterListVersion getOrCreateVersion(Date forDate, String versionType)
  {
    MasterListVersionQuery query = new MasterListVersionQuery(new QueryFactory());
    query.WHERE(query.getMasterlist().EQ(this));
    query.AND(query.getForDate().EQ(forDate));
    query.AND(query.getVersionType().EQ(versionType));

    try (OIterator<? extends MasterListVersion> it = query.getIterator())
    {
      if (it.hasNext())
      {
        return it.next();
      }
    }

    return MasterListVersion.create(this, forDate, versionType);
  }

  @Transaction
  public void publishFrequencyVersions()
  {
    try
    {
      Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

      final ServerGeoObjectType objectType = this.getGeoObjectType();
      Pair<Date, Date> range = VertexServerGeoObject.getDataRange(objectType);
      List<Date> dates = this.getFrequencyDates(range.getFirst(), range.getSecond());

      for (Date date : dates)
      {
        MasterListVersion version = this.getOrCreateVersion(date, MasterListVersion.PUBLISHED);

        ( (Session) Session.getCurrentSession() ).reloadPermissions();

        version.publish();
        version.generateShapefile();
      }
    }
    finally
    {
      Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
    }
  }

  public ServerGeoObjectType getGeoObjectType()
  {
    return ServerGeoObjectType.get(this.getUniversal());
  }

  public static MasterList fromJSON(JsonObject object)
  {
    try
    {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      String typeCode = object.get(MasterList.TYPE_CODE).getAsString();
      ServerGeoObjectType type = ServerGeoObjectType.get(typeCode);

      LocalizedValue label = LocalizedValue.fromJSON(object.get(MasterList.DISPLAYLABEL).getAsJsonObject());

      MasterList list = null;

      if (object.has("oid") && !object.get("oid").isJsonNull())
      {
        String oid = object.get("oid").getAsString();

        list = MasterList.lock(oid);
      }
      else
      {
        list = new MasterList();
      }

      list.setUniversal(type.getUniversal());
      LocalizedValueConverter.populate(list.getDisplayLabel(), label);
      list.setCode(object.get(MasterList.CODE).getAsString());
      list.setListAbstract(object.get(MasterList.LISTABSTRACT).getAsString());
      list.setProcess(object.get(MasterList.PROCESS).getAsString());
      list.setProgress(object.get(MasterList.PROGRESS).getAsString());
      list.setAccessConstraints(object.get(MasterList.ACCESSCONSTRAINTS).getAsString());
      list.setUseConstraints(object.get(MasterList.USECONSTRAINTS).getAsString());
      list.setAcknowledgements(object.get(MasterList.ACKNOWLEDGEMENTS).getAsString());
      list.setDisclaimer(object.get(MasterList.DISCLAIMER).getAsString());
      list.setContactName(object.get(MasterList.CONTACTNAME).getAsString());
      list.setOrganization(object.get(MasterList.ORGANIZATION).getAsString());
      list.setTelephoneNumber(object.get(MasterList.TELEPHONENUMBER).getAsString());
      list.setEmail(object.get(MasterList.EMAIL).getAsString());
      list.setHierarchies(object.get(MasterList.HIERARCHIES).getAsJsonArray().toString());

      if (object.has(MasterList.FREQUENCY) && !object.get(MasterList.FREQUENCY).isJsonNull())
      {
        final String frequency = object.get(MasterList.FREQUENCY).getAsString();

        list.clearFrequency();
        list.addFrequency(ChangeFrequency.valueOf(frequency));
      }

      if (object.has(MasterList.REPRESENTATIVITYDATE))
      {
        if (!object.get(MasterList.REPRESENTATIVITYDATE).isJsonNull())
        {
          String date = object.get(MasterList.REPRESENTATIVITYDATE).getAsString();

          if (date.length() > 0)
          {
            list.setRepresentativityDate(format.parse(date));
          }
          else
          {
            list.setRepresentativityDate(null);
          }
        }
        else
        {
          list.setRepresentativityDate(null);
        }
      }

      if (object.has(MasterList.PUBLISHDATE))
      {
        if (!object.get(MasterList.PUBLISHDATE).isJsonNull())
        {
          String date = object.get(MasterList.PUBLISHDATE).getAsString();

          if (date.length() > 0)
          {
            list.setPublishDate(format.parse(date));
          }
          else
          {
            list.setPublishDate(null);
          }
        }
        else
        {
          list.setPublishDate(null);
        }
      }

      return list;
    }
    catch (ParseException e)
    {
      throw new ProgrammingErrorException(e);
    }
  }

  @Transaction
  public static MasterList create(JsonObject object)
  {
    MasterList list = MasterList.fromJSON(object);
    list.apply();

    return list;
  }

  @Transaction
  public static void deleteAll(Universal universal)
  {
    MasterListQuery query = new MasterListQuery(new QueryFactory());
    query.WHERE(query.getUniversal().EQ(universal));

    List<? extends MasterList> lists = query.getIterator().getAll();

    for (MasterList list : lists)
    {
      list.delete();
    }
  }

  public static void createMdAttribute(ServerGeoObjectType type, AttributeType attributeType)
  {
    List<Locale> locales = SupportedLocaleDAO.getSupportedLocales();

    MasterListQuery query = new MasterListQuery(new QueryFactory());
    query.WHERE(query.getUniversal().EQ(type.getUniversal()));

    List<? extends MasterList> lists = query.getIterator().getAll();

    for (MasterList list : lists)
    {
      list.createMdAttributeFromAttributeType(type, attributeType, locales);
    }
  }

  public static void deleteMdAttribute(Universal universal, AttributeType attributeType)
  {
    MasterListQuery query = new MasterListQuery(new QueryFactory());
    query.WHERE(query.getUniversal().EQ(universal));

    List<? extends MasterList> lists = query.getIterator().getAll();

    for (MasterList list : lists)
    {
      list.removeAttributeType(attributeType);
    }
  }

  public static boolean isValidName(String name)
  {
    if (name.contains(" ") || name.contains("<") || name.contains(">") || name.contains("-") || name.contains("+") || name.contains("=") || name.contains("!") || name.contains("@") || name.contains("#") || name.contains("$") || name.contains("%") || name.contains("^") || name.contains("&") || name.contains("*") || name.contains("?") || name.contains(";") || name.contains(":") || name.contains(",") || name.contains("^") || name.contains("{") || name.contains("}") || name.contains("]") || name.contains("[") || name.contains("`") || name.contains("~") || name.contains("|") || name.contains("/") || name.contains("\\"))
    {
      return false;
    }

    return true;
  }

  public static JsonArray list()
  {
    JsonArray response = new JsonArray();

    MasterListQuery query = new MasterListQuery(new QueryFactory());
    query.ORDER_BY_DESC(query.getDisplayLabel().localize());

    OIterator<? extends MasterList> it = query.getIterator();

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    try
    {
      while (it.hasNext())
      {
        MasterList list = it.next();

        JsonObject object = new JsonObject();
        object.addProperty("label", list.getDisplayLabel().getValue());
        object.addProperty("oid", list.getOid());

        object.addProperty("createDate", format.format(list.getCreateDate()));
        object.addProperty("lasteUpdateDate", format.format(list.getLastUpdateDate()));

        response.add(object);
      }
    }
    finally
    {
      it.close();
    }

    return response;
  }

  public static JsonArray listByOrg()
  {
    JsonArray response = new JsonArray();

    String[] orgs = new String[] { "Test" };

    for (String org : orgs)
    {
      MasterListQuery query = new MasterListQuery(new QueryFactory());
      query.ORDER_BY_DESC(query.getDisplayLabel().localize());

      OIterator<? extends MasterList> it = query.getIterator();

      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

      JsonArray lists = new JsonArray();

      try
      {
        while (it.hasNext())
        {
          MasterList list = it.next();

          JsonObject object = new JsonObject();
          object.addProperty("label", list.getDisplayLabel().getValue());
          object.addProperty("oid", list.getOid());

          object.addProperty("createDate", format.format(list.getCreateDate()));
          object.addProperty("lasteUpdateDate", format.format(list.getLastUpdateDate()));

          lists.add(object);
        }
      }
      finally
      {
        it.close();
      }

      JsonObject object = new JsonObject();
      object.addProperty("oid", "test");
      object.addProperty("label", org);
      object.add("lists", lists);

      response.add(object);
    }

    return response;
  }

}
