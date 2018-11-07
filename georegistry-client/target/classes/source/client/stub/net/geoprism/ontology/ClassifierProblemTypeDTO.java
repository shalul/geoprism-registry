/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK(tm).
 *
 * Runway SDK(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package net.geoprism.ontology;

/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 *
 * @author Autogenerated by RunwaySDK
 */
@com.runwaysdk.business.ClassSignature(hash = 962064088)
public enum ClassifierProblemTypeDTO implements com.runwaysdk.business.EnumerationDTOIF
{
  UNMATCHED();
  
  public final static String CLASS = "net.geoprism.ontology.ClassifierProblemType";
  
  
  public net.geoprism.ontology.ClassifierProblemTypeMasterDTO item(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (net.geoprism.ontology.ClassifierProblemTypeMasterDTO) clientRequest.getEnumeration(net.geoprism.ontology.ClassifierProblemTypeDTO.CLASS, this.name());
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<net.geoprism.ontology.ClassifierProblemTypeMasterDTO> items(com.runwaysdk.constants.ClientRequestIF clientRequest, ClassifierProblemTypeDTO ... items)
  {
    java.lang.String[] itemNames = new java.lang.String[items.length];
    for(int i=0; i<items.length; i++)
    {
      itemNames[i] = items[i].name();
    }
    return (java.util.List<net.geoprism.ontology.ClassifierProblemTypeMasterDTO>) clientRequest.getEnumerations(net.geoprism.ontology.ClassifierProblemTypeDTO.CLASS, itemNames);
  }
  
  @java.lang.SuppressWarnings("unchecked")
  public static java.util.List<net.geoprism.ontology.ClassifierProblemTypeMasterDTO> allItems(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    return (java.util.List<net.geoprism.ontology.ClassifierProblemTypeMasterDTO>) clientRequest.getAllEnumerations(net.geoprism.ontology.ClassifierProblemTypeDTO.CLASS);
  }
  
  public java.lang.String getName()
  {
    return this.name();
  }
}
