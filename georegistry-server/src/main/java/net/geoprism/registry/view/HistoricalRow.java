/**
 * Copyright (c) 2019 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Geoprism Registry(tm).
 *
 * Geoprism Registry(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Geoprism Registry(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Geoprism Registry(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package net.geoprism.registry.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.commongeoregistry.adapter.dataaccess.LocalizedValue;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.runwaysdk.business.graph.GraphQuery;
import com.runwaysdk.dataaccess.MdAttributeDAOIF;
import com.runwaysdk.dataaccess.MdVertexDAOIF;
import com.runwaysdk.dataaccess.metadata.graph.MdVertexDAO;

import net.geoprism.localization.LocalizationFacade;
import net.geoprism.registry.conversion.LocalizedValueConverter;
import net.geoprism.registry.etl.export.SeverGeoObjectJsonAdapters;
import net.geoprism.registry.excel.HistoricalReportExcelExporter;
import net.geoprism.registry.graph.transition.Transition;
import net.geoprism.registry.graph.transition.TransitionEvent;
import net.geoprism.registry.model.ServerGeoObjectType;

public class HistoricalRow implements JsonSerializable
{
  public static final String EVENT_ID     = "eventId";

  public static final String EVENT_DATE   = "eventDate";

  public static final String EVENT_TYPE   = "eventType";

  public static final String DESCRIPTION  = "description";

  public static final String BEFORE_TYPE  = "beforeType";

  public static final String BEFORE_CODE  = "beforeCode";

  public static final String BEFORE_LABEL = "beforeLabel";

  public static final String AFTER_TYPE   = "afterType";

  public static final String AFTER_CODE   = "afterCode";

  public static final String AFTER_LABEL  = "afterLabel";

  private Long               eventId;

  private Date               eventDate;

  private String             eventType;

  private LocalizedValue     description;

  private String             beforeType;

  private String             beforeCode;

  private LocalizedValue     beforeLabel;

  private String             afterType;

  private String             afterCode;

  private LocalizedValue     afterLabel;

  public Long getEventId()
  {
    return eventId;
  }

  public void setEventId(Long eventId)
  {
    this.eventId = eventId;
  }

  public Date getEventDate()
  {
    return eventDate;
  }

  public void setEventDate(Date eventDate)
  {
    this.eventDate = eventDate;
  }

  public LocalizedValue getDescription()
  {
    return description;
  }

  public void setDescription(LocalizedValue description)
  {
    this.description = description;
  }

  public String getBeforeType()
  {
    return beforeType;
  }

  public void setBeforeType(String beforeType)
  {
    this.beforeType = beforeType;
  }

  public String getBeforeCode()
  {
    return beforeCode;
  }

  public void setBeforeCode(String beforeCode)
  {
    this.beforeCode = beforeCode;
  }

  public LocalizedValue getBeforeLabel()
  {
    return beforeLabel;
  }

  public void setBeforeLabel(LocalizedValue beforeLabel)
  {
    this.beforeLabel = beforeLabel;
  }

  public String getAfterType()
  {
    return afterType;
  }

  public void setAfterType(String afterType)
  {
    this.afterType = afterType;
  }

  public String getAfterCode()
  {
    return afterCode;
  }

  public void setAfterCode(String afterCode)
  {
    this.afterCode = afterCode;
  }

  public LocalizedValue getAfterLabel()
  {
    return afterLabel;
  }

  public void setAfterLabel(LocalizedValue afterLabel)
  {
    this.afterLabel = afterLabel;
  }

  public String getEventType()
  {
    return eventType;
  }

  public void setEventType(String eventType)
  {
    this.eventType = eventType;
  }

  public String getLocalizedEventType()
  {
    String eventType = this.getEventType();

    String[] split = eventType.split("_");

    if (split.length > 1)
    {
      StringBuilder builder = new StringBuilder();
      builder.append(LocalizationFacade.getFromBundles("transition.event.type." + split[1].toLowerCase()));
      builder.append(" - ");
      builder.append(LocalizationFacade.getFromBundles("transition.event.type." + split[0].toLowerCase()));

      return builder.toString();
    }

    return LocalizationFacade.getFromBundles("transition.event.type." + eventType.toLowerCase());
  }

  @Override
  public JsonElement toJSON()
  {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(LocalizedValue.class, new SeverGeoObjectJsonAdapters.LocalizedValueSerializer());
    builder.registerTypeAdapter(Date.class, new SeverGeoObjectJsonAdapters.DateSerializer());

    JsonObject json = builder.create().toJsonTree(this, this.getClass()).getAsJsonObject();
    json.addProperty(EVENT_TYPE, this.getLocalizedEventType());

    return json;
  }

  @SuppressWarnings("unchecked")
  public static HistoricalRow parse(Map<String, Object> row)
  {
    Date eventDate = (Date) row.get(EVENT_DATE);

    HistoricalRow ret = new HistoricalRow();
    ret.setEventId((Long) row.get(EVENT_ID));
    ret.setEventDate(eventDate);
    ret.setEventType((String) row.get(EVENT_TYPE));
    ret.setDescription(LocalizedValueConverter.convert((Map<String, Object>) row.get(DESCRIPTION)));
    ret.setBeforeLabel(parseLabel(row, eventDate, BEFORE_LABEL));
    ret.setBeforeCode((String) row.get(BEFORE_CODE));
    ret.setBeforeType((String) row.get(BEFORE_TYPE));
    ret.setAfterLabel(parseLabel(row, eventDate, AFTER_LABEL));
    ret.setAfterCode((String) row.get(AFTER_CODE));
    ret.setAfterType((String) row.get(AFTER_TYPE));

    return ret;
  }

  @SuppressWarnings("unchecked")
  private static LocalizedValue parseLabel(Map<String, Object> row, Date date, String attributeName)
  {
    List<Map<String, Object>> labels = (List<Map<String, Object>>) row.get(attributeName);

    return LocalizedValueConverter.convert(labels, date);
  }

  public static Long getCount(ServerGeoObjectType type, Date startDate, Date endDate)
  {
    MdVertexDAOIF transitionVertex = MdVertexDAO.getMdVertexDAO(Transition.CLASS);
    MdAttributeDAOIF eventAttribute = transitionVertex.definesAttribute(Transition.EVENT);

    MdVertexDAOIF eventVertex = MdVertexDAO.getMdVertexDAO(TransitionEvent.CLASS);
    MdAttributeDAOIF beforeTypeCode = eventVertex.definesAttribute(TransitionEvent.BEFORETYPECODE);
    MdAttributeDAOIF afterTypeCode = eventVertex.definesAttribute(TransitionEvent.AFTERTYPECODE);
    MdAttributeDAOIF eventDate = eventVertex.definesAttribute(TransitionEvent.EVENTDATE);

    List<ServerGeoObjectType> types = new LinkedList<ServerGeoObjectType>();
    types.add(type);
    types.addAll(type.getSubtypes());

    List<String> codes = types.stream().map(t -> t.getCode()).distinct().collect(Collectors.toList());

    StringBuilder statement = new StringBuilder();
    statement.append("SELECT COUNT(*)");
    statement.append(" FROM " + transitionVertex.getDBClassName());
    statement.append(" WHERE ( " + eventAttribute.getColumnName() + "." + beforeTypeCode.getColumnName() + " IN :typeCode");
    statement.append(" OR " + eventAttribute.getColumnName() + "." + afterTypeCode.getColumnName() + " IN :typeCode )");
    statement.append(" AND " + eventAttribute.getColumnName() + "." + eventDate.getColumnName() + " BETWEEN :startDate AND :endDate");

    GraphQuery<Long> query = new GraphQuery<Long>(statement.toString());
    query.setParameter("typeCode", codes);
    query.setParameter("startDate", startDate);
    query.setParameter("endDate", endDate);

    return query.getSingleResult();
  }

  public static Page<HistoricalRow> getHistoricalReport(ServerGeoObjectType type, Date startDate, Date endDate, Integer pageSize, Integer pageNumber)
  {
    MdVertexDAOIF transitionVertex = MdVertexDAO.getMdVertexDAO(Transition.CLASS);
    MdAttributeDAOIF eventAttribute = transitionVertex.definesAttribute(Transition.EVENT);
    MdAttributeDAOIF sourceAttribute = transitionVertex.definesAttribute(Transition.SOURCE);
    MdAttributeDAOIF targetAttribute = transitionVertex.definesAttribute(Transition.TARGET);
    MdAttributeDAOIF transitionAttribute = transitionVertex.definesAttribute(Transition.TRANSITIONTYPE);

    MdVertexDAOIF eventVertex = MdVertexDAO.getMdVertexDAO(TransitionEvent.CLASS);
    MdAttributeDAOIF eventId = eventVertex.definesAttribute(TransitionEvent.EVENTID);
    MdAttributeDAOIF beforeTypeCode = eventVertex.definesAttribute(TransitionEvent.BEFORETYPECODE);
    MdAttributeDAOIF afterTypeCode = eventVertex.definesAttribute(TransitionEvent.AFTERTYPECODE);
    MdAttributeDAOIF eventDate = eventVertex.definesAttribute(TransitionEvent.EVENTDATE);
    MdAttributeDAOIF description = eventVertex.definesAttribute(TransitionEvent.DESCRIPTION);

    List<ServerGeoObjectType> types = new LinkedList<ServerGeoObjectType>();
    types.add(type);
    types.addAll(type.getSubtypes());

    List<String> codes = types.stream().map(t -> t.getCode()).distinct().collect(Collectors.toList());

    StringBuilder statement = new StringBuilder();
    statement.append("SELECT " + eventAttribute.getColumnName() + "." + eventId.getColumnName() + " AS " + HistoricalRow.EVENT_ID);
    statement.append(", " + eventAttribute.getColumnName() + "." + eventDate.getColumnName() + " AS " + HistoricalRow.EVENT_DATE);
    statement.append(", " + transitionAttribute.getColumnName() + " AS " + HistoricalRow.EVENT_TYPE);
    statement.append(", " + eventAttribute.getColumnName() + "." + description.getColumnName() + " AS " + HistoricalRow.DESCRIPTION);
    statement.append(", " + eventAttribute.getColumnName() + "." + beforeTypeCode.getColumnName() + " AS " + HistoricalRow.BEFORE_TYPE);
    statement.append(", " + sourceAttribute.getColumnName() + ".code AS " + HistoricalRow.BEFORE_CODE);
    statement.append(", " + sourceAttribute.getColumnName() + ".displayLabel_cot AS " + HistoricalRow.BEFORE_LABEL);
    statement.append(", " + eventAttribute.getColumnName() + "." + afterTypeCode.getColumnName() + " AS " + HistoricalRow.AFTER_TYPE);
    statement.append(", " + targetAttribute.getColumnName() + ".code AS " + HistoricalRow.AFTER_CODE);
    statement.append(", " + targetAttribute.getColumnName() + ".displayLabel_cot AS " + HistoricalRow.AFTER_LABEL);
    statement.append(" FROM " + transitionVertex.getDBClassName());
    statement.append(" WHERE ( " + eventAttribute.getColumnName() + "." + beforeTypeCode.getColumnName() + " IN :typeCode");
    statement.append(" OR " + eventAttribute.getColumnName() + "." + afterTypeCode.getColumnName() + " IN :typeCode )");
    statement.append(" AND " + eventAttribute.getColumnName() + "." + eventDate.getColumnName() + " BETWEEN :startDate AND :endDate");
    statement.append(" ORDER BY " + eventAttribute.getColumnName() + "." + eventDate.getColumnName() + " DESC");
    statement.append(", " + eventAttribute.getColumnName() + "." + eventId.getColumnName());
    statement.append(", " + sourceAttribute.getColumnName() + ".code");
    statement.append(", " + targetAttribute.getColumnName() + ".code");

    if (pageNumber != null && pageSize != null)
    {
      statement.append(" SKIP " + ( ( pageNumber - 1 ) * pageSize ) + " LIMIT " + pageSize);
    }

    GraphQuery<Map<String, Object>> query = new GraphQuery<Map<String, Object>>(statement.toString());
    query.setParameter("typeCode", codes);
    query.setParameter("startDate", startDate);
    query.setParameter("endDate", endDate);

    Long count = getCount(type, startDate, endDate);

    List<HistoricalRow> results = query.getRawResults().stream().map(list -> HistoricalRow.parse(list)).collect(Collectors.toList());

    return new Page<HistoricalRow>(count, pageNumber, pageSize, results);
  }

  public static InputStream exportToExcel(ServerGeoObjectType type, Date startDate, Date endDate) throws IOException
  {
    HistoricalReportExcelExporter exporter = new HistoricalReportExcelExporter(type, startDate, endDate);

    return exporter.export();
  }

}