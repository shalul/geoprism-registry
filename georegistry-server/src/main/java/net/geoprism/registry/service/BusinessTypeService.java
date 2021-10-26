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
package net.geoprism.registry.service;

import org.commongeoregistry.adapter.metadata.AttributeType;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.runwaysdk.session.Request;
import com.runwaysdk.session.RequestType;
import com.runwaysdk.session.Session;

import net.geoprism.registry.BusinessType;

public class BusinessTypeService
{

  /**
   * Creates a {@link BusinessType} from the given JSON.
   * 
   * @param sessionId
   * @param ptJSON
   *          JSON of the {@link BusinessType} to be created.
   * @return newly created {@link BusinessType}
   */
  @Request(RequestType.SESSION)
  public JsonObject apply(String sessionId, String ptJSON)
  {
    BusinessType type = BusinessType.apply(JsonParser.parseString(ptJSON).getAsJsonObject());

    ( (Session) Session.getCurrentSession() ).reloadPermissions();

    return type.toJSON();
  }

  @Request(RequestType.SESSION)
  public JsonArray listByOrg(String sessionId)
  {
    return BusinessType.listByOrg();
  }

  @Request(RequestType.SESSION)
  public JsonArray getAll(String sessionId)
  {
    return BusinessType.getAll();
  }

  @Request(RequestType.SESSION)
  public void remove(String sessionId, String oid)
  {
    BusinessType type = BusinessType.get(oid);
    type.delete();

    ( (Session) Session.getCurrentSession() ).reloadPermissions();
  }

  @Request(RequestType.SESSION)
  public JsonObject edit(String sessionId, String oid)
  {
    BusinessType type = BusinessType.get(oid);
    type.lock();

    return type.toJSON(true);
  }

  @Request(RequestType.SESSION)
  public void unlock(String sessionId, String oid)
  {
    BusinessType type = BusinessType.get(oid);
    type.unlock();
  }

  /**
   * Adds an attribute to the given {@link BusinessType}.
   * 
   * @pre given {@link BusinessType} must already exist.
   * 
   * @param sessionId
   *
   * @param businessTypeCode
   *          string of the {@link BusinessType} to be updated.
   * @param attributeTypeJSON
   *          AttributeType to be added to the BusinessType
   * @return updated {@link BusinessType}
   */
  @Request(RequestType.SESSION)
  public AttributeType createAttributeType(String sessionId, String businessTypeCode, String attributeTypeJSON)
  {
    BusinessType got = BusinessType.getByCode(businessTypeCode);

    // ServiceFactory.getBusinessTypePermissionService().enforceCanWrite(got.getOrganization().getCode(),
    // got, got.getIsPrivate());

    AttributeType attrType = got.createAttributeType(attributeTypeJSON);

    return attrType;
  }

  /**
   * Updates an attribute in the given {@link BusinessType}.
   * 
   * @pre given {@link BusinessType} must already exist.
   * 
   * @param sessionId
   * @param businessTypeCode
   *          string of the {@link BusinessType} to be updated.
   * @param attributeTypeJSON
   *          AttributeType to be added to the BusinessType
   * @return updated {@link AttributeType}
   */
  @Request(RequestType.SESSION)
  public AttributeType updateAttributeType(String sessionId, String businessTypeCode, String attributeTypeJSON)
  {
    BusinessType got = BusinessType.getByCode(businessTypeCode);

    // ServiceFactory.getBusinessTypePermissionService().enforceCanWrite(got.getOrganization().getCode(),
    // got, got.getIsPrivate());

    AttributeType attrType = got.updateAttributeType(attributeTypeJSON);

    return attrType;
  }

  /**
   * Deletes an attribute from the given {@link BusinessType}.
   * 
   * @pre given {@link BusinessType} must already exist.
   * @pre given {@link BusinessType} must already exist.
   * 
   * @param sessionId
   * @param code
   *          string of the {@link BusinessType} to be updated.
   * @param attributeName
   *          Name of the attribute to be removed from the BusinessType
   * @return updated {@link BusinessType}
   */
  @Request(RequestType.SESSION)
  public void removeAttributeType(String sessionId, String businessTypeCode, String attributeName)
  {
    BusinessType got = BusinessType.getByCode(businessTypeCode);

    // ServiceFactory.getBusinessTypePermissionService().enforceCanWrite(got.getOrganization().getCode(),
    // got, got.getIsPrivate());

    got.removeAttribute(attributeName);
  }

}