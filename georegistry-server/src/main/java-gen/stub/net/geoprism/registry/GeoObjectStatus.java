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
package net.geoprism.registry;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = -2052417253)
public enum GeoObjectStatus implements com.runwaysdk.business.BusinessEnumeration
{
  ACTIVE(),
  
  INACTIVE(),
  
  NEW(),
  
  PENDING();
  
  public static final java.lang.String CLASS = "net.geoprism.registry.GeoObjectStatus";
  private net.geoprism.registry.GeoObjectStatusMaster enumeration;
  
  private synchronized void loadEnumeration()
  {
    net.geoprism.registry.GeoObjectStatusMaster enu = net.geoprism.registry.GeoObjectStatusMaster.getEnumeration(this.name());
    setEnumeration(enu);
  }
  
  private synchronized void setEnumeration(net.geoprism.registry.GeoObjectStatusMaster enumeration)
  {
    this.enumeration = enumeration;
  }
  
  public Integer getStatusOrder()
  {
    loadEnumeration();
    return enumeration.getStatusOrder();
  }
  
  public java.lang.String getOid()
  {
    loadEnumeration();
    return enumeration.getOid();
  }
  
  public java.lang.String getEnumName()
  {
    loadEnumeration();
    return enumeration.getEnumName();
  }
  
  public java.lang.String getDisplayLabel()
  {
    loadEnumeration();
    return enumeration.getDisplayLabel().getValue(com.runwaysdk.session.Session.getCurrentLocale());
  }
  
  public static GeoObjectStatus get(String oid)
  {
    for (GeoObjectStatus e : GeoObjectStatus.values())
    {
      if (e.getOid().equals(oid))
      {
        return e;
      }
    }
    return null;
  }
  
}