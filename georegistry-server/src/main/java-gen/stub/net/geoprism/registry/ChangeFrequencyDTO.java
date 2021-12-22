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
package net.geoprism.registry;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 1380357688)
public enum ChangeFrequencyDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  ANNUAL(),
  
  BIANNUAL(),
  
  DAILY(),
  
  MONTHLY(),
  
  QUARTER();
  
  public final static String CLASS = "net.geoprism.registry.ChangeFrequency";
  
  
  public net.geoprism.registry.ChangeFrequencyMasterDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (net.geoprism.registry.ChangeFrequencyMasterDTO) clientRequest.getEnumeration(net.geoprism.registry.ChangeFrequencyDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<net.geoprism.registry.ChangeFrequencyMasterDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, ChangeFrequencyDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<net.geoprism.registry.ChangeFrequencyMasterDTO>) clientRequest.getEnumerations(net.geoprism.registry.ChangeFrequencyDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<net.geoprism.registry.ChangeFrequencyMasterDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<net.geoprism.registry.ChangeFrequencyMasterDTO>) clientRequest.getAllEnumerations(net.geoprism.registry.ChangeFrequencyDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
