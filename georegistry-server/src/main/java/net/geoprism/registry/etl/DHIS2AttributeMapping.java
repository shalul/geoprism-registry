/**
 * Copyright (c) 2022 TerraFrame, Inc. All rights reserved.
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
package net.geoprism.registry.etl;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import org.commongeoregistry.adapter.Term;
import org.commongeoregistry.adapter.constants.DefaultAttribute;
import org.commongeoregistry.adapter.dataaccess.LocalizedValue;
import org.commongeoregistry.adapter.metadata.AttributeBooleanType;
import org.commongeoregistry.adapter.metadata.AttributeCharacterType;
import org.commongeoregistry.adapter.metadata.AttributeDateType;
import org.commongeoregistry.adapter.metadata.AttributeFloatType;
import org.commongeoregistry.adapter.metadata.AttributeIntegerType;
import org.commongeoregistry.adapter.metadata.AttributeLocalType;
import org.commongeoregistry.adapter.metadata.AttributeTermType;
import org.commongeoregistry.adapter.metadata.AttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.runwaysdk.dataaccess.ProgrammingErrorException;
import com.runwaysdk.localization.LocalizationFacade;

import net.geoprism.dhis2.dhis2adapter.response.model.Attribute;
import net.geoprism.dhis2.dhis2adapter.response.model.Option;
import net.geoprism.dhis2.dhis2adapter.response.model.ValueType;
import net.geoprism.registry.etl.export.dhis2.DHIS2GeoObjectJsonAdapters;
import net.geoprism.registry.etl.export.dhis2.DHIS2OptionCache;
import net.geoprism.registry.etl.export.dhis2.DHIS2OptionCache.IntegratedOptionSet;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.graph.VertexServerGeoObject;

public class DHIS2AttributeMapping
{
  public static final String ATTRIBUTE_MAPPING_STRATEGY_JSON = "attributeMappingStrategy";
  
  private static final Logger logger = LoggerFactory.getLogger(DHIS2AttributeMapping.class);
  
  @SerializedName(ATTRIBUTE_MAPPING_STRATEGY_JSON)
  protected String attributeMappingStrategy;
  
  protected String cgrAttrName;
  
  protected String dhis2AttrName;
  
  protected String externalId;
  
  public DHIS2AttributeMapping(String cgrAttrName)
  {
    this.cgrAttrName = cgrAttrName;
  }
  
  public DHIS2AttributeMapping()
  {
    
  }
  
  protected String getLabel()
  {
    if (cgrAttrName != null && cgrAttrName.equals(DefaultAttribute.EXISTS.getName()))
    {
      return LocalizationFacade.localize("sync.attr.mapStrategy.existValue");
    }
    else
    {
      return null;
    }
  }
  
  public String getExternalId()
  {
    return externalId;
  }

  public void setExternalId(String externalId)
  {
    this.externalId = externalId;
  }

  public String getCgrAttrName()
  {
    return cgrAttrName;
  }

  public void setCgrAttrName(String name)
  {
    this.cgrAttrName = name;
  }
  
  public String getAttributeMappingStrategy()
  {
    if (attributeMappingStrategy == null || attributeMappingStrategy.length() == 0)
    {
      return DHIS2AttributeMapping.class.getName();
    }
    else
    {
      return attributeMappingStrategy;
    }
  }

  public void setAttributeMappingStrategy(String attributeMappingStrategy)
  {
    this.attributeMappingStrategy = attributeMappingStrategy;
  }

  public String getDhis2AttrName()
  {
    return dhis2AttrName;
  }

  public void setDhis2AttrName(String dhis2AttrName)
  {
    this.dhis2AttrName = dhis2AttrName;
  }

  public boolean isStandardAttribute()
  {
    return this.cgrAttrName != null && this.cgrAttrName.length() > 0
        && this.dhis2AttrName != null && this.dhis2AttrName.length() > 0
        && (this.externalId == null || this.externalId.length() == 0);
  }
  
  public boolean isCustomAttribute()
  {
    return this.cgrAttrName != null && this.cgrAttrName.length() > 0
        && this.dhis2AttrName != null && this.dhis2AttrName.length() > 0
        && this.externalId != null && this.externalId.length() > 0;
  }

  // DHIS2 makes a clear distinction between built-in attributes and custom attributes. Only custom attributes actually have ids. Standard attributes are referenced via their name.
  public void writeStandardAttributes(VertexServerGeoObject serverGo, Date date, JsonObject jo, DHIS2SyncConfig dhis2Config, DHIS2SyncLevel level)
  {
    if (this.isStandardAttribute())
    {
      ServerGeoObjectType got = level.getGeoObjectType();
      AttributeType attr = got.getAttribute(this.getCgrAttrName()).get();
      
      Object value = this.getAttributeValue(serverGo, date, attr, got);
      
      if (value == null || (value instanceof String && ((String)value).length() == 0))
      {
        return;
      }
      
      this.writeAttributeValue(attr, this.dhis2AttrName, value, jo);
    }
  }

  // DHIS2 makes a clear distinction between built-in attributes and custom attributes. Only custom attributes actually have ids. Standard attributes are referenced via their name.
  public void writeCustomAttributes(JsonArray attributeValues, VertexServerGeoObject serverGo, Date date, DHIS2SyncConfig dhis2Config, DHIS2SyncLevel syncLevel, String lastUpdateDate, String createDate)
  {
    if (this.isCustomAttribute())
    {
      ServerGeoObjectType got = syncLevel.getGeoObjectType();
      AttributeType attr = got.getAttribute(this.getCgrAttrName()).get();
      
      Object value = this.getAttributeValue(serverGo, date, attr, got);
      
      if (value == null || (value instanceof String && ((String)value).length() == 0))
      {
        return;
      }
      
      JsonObject av = new JsonObject();

      av.addProperty("lastUpdated", lastUpdateDate);

      av.addProperty("created", createDate);

      this.writeAttributeValue(attr, "value", value, av);

      JsonObject joAttr = new JsonObject();
      joAttr.addProperty("id", this.getExternalId());
      av.add("attribute", joAttr);

      attributeValues.add(av);
    }
  }
  
  protected Object getAttributeValue(VertexServerGeoObject serverGo, Date date, AttributeType attr, ServerGeoObjectType got)
  {
    if (date == null)
    {
      return serverGo.getValue(attr.getName());
    }
    else
    {
      return serverGo.getValue(attr.getName(), date);
    }
  }

  protected void writeAttributeValue(AttributeType attr, String propertyName, Object value, JsonObject json)
  {
    if (attr instanceof AttributeBooleanType)
    {
      json.addProperty(propertyName, (Boolean) value);
    }
    else if (attr instanceof AttributeIntegerType)
    {
      json.addProperty(propertyName, (Long) value);
    }
    else if (attr instanceof AttributeFloatType)
    {
      json.addProperty(propertyName, (Double) value);
    }
    else if (attr instanceof AttributeDateType)
    {
      json.addProperty(propertyName, DHIS2GeoObjectJsonAdapters.DHIS2Serializer.formatDate((Date) value));
    }
    else if (attr instanceof AttributeLocalType)
    {
      json.addProperty(propertyName, ((LocalizedValue)value).getValue(LocalizedValue.DEFAULT_LOCALE));
    }
    else
    {
      json.addProperty(propertyName, String.valueOf(value));
    }
  }
  
  public static class DHIS2AttributeMappingDeserializer implements JsonDeserializer<DHIS2AttributeMapping>
  {
    private Gson defaultGson = new Gson();
    
    @Override
    public DHIS2AttributeMapping deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
      JsonObject jo = json.getAsJsonObject();
      
      String typeName;
      if (jo.has(ATTRIBUTE_MAPPING_STRATEGY_JSON))
      {
        typeName = jo.get(ATTRIBUTE_MAPPING_STRATEGY_JSON).getAsString();
      }
      else
      {
        typeName = DHIS2AttributeMapping.class.getName();
      }
      
      try
      {
        @SuppressWarnings("unchecked")
        Class<DHIS2AttributeMapping> clazz = (Class<DHIS2AttributeMapping>) DHIS2AttributeMapping.class.getClassLoader().loadClass(typeName);
        return defaultGson.fromJson(json, clazz);
      }
      catch (ClassNotFoundException | SecurityException e)
      {
        logger.error("Unable to instantiate mapping strategy.", e);
        throw new ProgrammingErrorException(e);
      }
    }
  }
  
  public static class DHIS2AttributeMappingSerializer implements JsonSerializer<DHIS2AttributeMapping>
  {
    @Override
    public JsonElement serialize(DHIS2AttributeMapping mapping, Type typeOfSrc, JsonSerializationContext context)
    {
      final GsonBuilder builder = new GsonBuilder();
      builder.serializeNulls();
      final Gson gson = builder.create();
      
      if (mapping instanceof DHIS2OptionSetAttributeMapping)
      {
        return gson.toJsonTree(mapping, DHIS2OptionSetAttributeMapping.class);
      }
      else
      {
        return gson.toJsonTree(mapping, DHIS2AttributeMapping.class);
      }
    }
  }

  public JsonObject getConfigurationInfo(final DHIS2OptionCache optionCache, List<Attribute> dhis2Attrs, AttributeType cgrAttr)
  {
    JsonObject configInfo = new JsonObject();
    
    configInfo.addProperty("type", this.getClass().getName());
    
    String label = this.getLabel();
    if (label != null)
    {
      configInfo.addProperty("label", this.getLabel());
    }
    
    JsonArray jaDhis2Attrs = buildDhis2Attributes(optionCache, dhis2Attrs, cgrAttr);

    configInfo.add("dhis2Attrs", jaDhis2Attrs);

    if (cgrAttr instanceof AttributeTermType)
    {
      JsonArray terms = new JsonArray();

      List<Term> children = ( (AttributeTermType) cgrAttr ).getTerms();

      for (Term child : children)
      {
        JsonObject joTerm = new JsonObject();
        joTerm.addProperty("label", child.getLabel().getValue());
        joTerm.addProperty("code", child.getCode());
        terms.add(joTerm);
      }

      configInfo.add("terms", terms);
    }
    
    return configInfo;
  }

  protected JsonArray buildDhis2Attributes(final DHIS2OptionCache optionCache, List<Attribute> dhis2Attrs, AttributeType cgrAttr)
  {
    JsonArray jaDhis2Attrs = new JsonArray();
    
    for (Attribute dhis2Attr : dhis2Attrs)
    {
      if (!dhis2Attr.getOrganisationUnitAttribute() || dhis2Attr.getValueType() == null)
      {
        continue;
      }

      boolean valid = false;

      JsonObject joDhis2Attr = new JsonObject();

      if (cgrAttr instanceof AttributeBooleanType && dhis2Attr.getOptionSetId() == null && ( dhis2Attr.getValueType().equals(ValueType.BOOLEAN) || dhis2Attr.getValueType().equals(ValueType.TRUE_ONLY) ))
      {
        valid = true;
      }
      else if (cgrAttr instanceof AttributeIntegerType && dhis2Attr.getOptionSetId() == null && ( dhis2Attr.getValueType().equals(ValueType.INTEGER) || dhis2Attr.getValueType().equals(ValueType.INTEGER_POSITIVE) || dhis2Attr.getValueType().equals(ValueType.INTEGER_NEGATIVE) || dhis2Attr.getValueType().equals(ValueType.INTEGER_ZERO_OR_POSITIVE) ))
      {
        valid = true;
      }
      else if (cgrAttr instanceof AttributeFloatType && dhis2Attr.getOptionSetId() == null && ( dhis2Attr.getValueType().equals(ValueType.NUMBER) || dhis2Attr.getValueType().equals(ValueType.UNIT_INTERVAL) || dhis2Attr.getValueType().equals(ValueType.PERCENTAGE) ))
      {
        valid = true;
      }
      else if (cgrAttr instanceof AttributeDateType && dhis2Attr.getOptionSetId() == null && ( dhis2Attr.getValueType().equals(ValueType.DATE) || dhis2Attr.getValueType().equals(ValueType.DATETIME) || dhis2Attr.getValueType().equals(ValueType.TIME) || dhis2Attr.getValueType().equals(ValueType.AGE) ))
      {
        valid = true;
      }
      else if (cgrAttr instanceof AttributeTermType && dhis2Attr.getOptionSetId() != null)
      {
        valid = true;

        JsonArray jaDhis2Options = new JsonArray();

        IntegratedOptionSet set = optionCache.getOptionSet(dhis2Attr.getOptionSetId());

        SortedSet<Option> options = set.getOptions();

        for (Option option : options)
        {
          JsonObject joDhis2Option = new JsonObject();
          joDhis2Option.addProperty("code", option.getCode());
          joDhis2Option.addProperty("name", option.getName());
          joDhis2Option.addProperty("id", option.getName());
          jaDhis2Options.add(joDhis2Option);
        }

        joDhis2Attr.add("options", jaDhis2Options);
      }
      else if ( ( cgrAttr instanceof AttributeCharacterType || cgrAttr instanceof AttributeLocalType ) && dhis2Attr.getOptionSetId() == null && ( dhis2Attr.getValueType().equals(ValueType.TEXT) || dhis2Attr.getValueType().equals(ValueType.LONG_TEXT) || dhis2Attr.getValueType().equals(ValueType.LETTER) || dhis2Attr.getValueType().equals(ValueType.PHONE_NUMBER) || dhis2Attr.getValueType().equals(ValueType.EMAIL) || dhis2Attr.getValueType().equals(ValueType.USERNAME) || dhis2Attr.getValueType().equals(ValueType.URL) ))
      {
        valid = true;
      }

      if (valid)
      {
        joDhis2Attr.addProperty("dhis2Id", dhis2Attr.getId());
        joDhis2Attr.addProperty("code", dhis2Attr.getCode());
        joDhis2Attr.addProperty("name", dhis2Attr.getName());
        jaDhis2Attrs.add(joDhis2Attr);
      }
    }
    
    return jaDhis2Attrs;
  }
  
}
