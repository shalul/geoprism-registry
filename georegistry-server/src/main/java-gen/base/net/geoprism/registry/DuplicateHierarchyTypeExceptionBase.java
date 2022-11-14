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

@com.runwaysdk.business.ClassSignature(hash = -25417191)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to DuplicateHierarchyTypeException.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class DuplicateHierarchyTypeExceptionBase extends com.runwaysdk.business.SmartException
{
  public final static String CLASS = "net.geoprism.registry.DuplicateHierarchyTypeException";
  public static final java.lang.String DUPLICATEVALUE = "duplicateValue";
  public static final java.lang.String OID = "oid";
  private static final long serialVersionUID = -25417191;
  
  public DuplicateHierarchyTypeExceptionBase()
  {
    super();
  }
  
  public DuplicateHierarchyTypeExceptionBase(java.lang.String developerMessage)
  {
    super(developerMessage);
  }
  
  public DuplicateHierarchyTypeExceptionBase(java.lang.String developerMessage, java.lang.Throwable cause)
  {
    super(developerMessage, cause);
  }
  
  public DuplicateHierarchyTypeExceptionBase(java.lang.Throwable cause)
  {
    super(cause);
  }
  
  public String getDuplicateValue()
  {
    return getValue(DUPLICATEVALUE);
  }
  
  public void validateDuplicateValue()
  {
    this.validateAttribute(DUPLICATEVALUE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getDuplicateValueMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.DuplicateHierarchyTypeException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(DUPLICATEVALUE);
  }
  
  public void setDuplicateValue(String value)
  {
    if(value == null)
    {
      setValue(DUPLICATEVALUE, "");
    }
    else
    {
      setValue(DUPLICATEVALUE, value);
    }
  }
  
  public String getOid()
  {
    return getValue(OID);
  }
  
  public void validateOid()
  {
    this.validateAttribute(OID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF getOidMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.DuplicateHierarchyTypeException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public java.lang.String localize(java.util.Locale locale)
  {
    java.lang.String message = super.localize(locale);
    message = replace(message, "{duplicateValue}", this.getDuplicateValue());
    message = replace(message, "{oid}", this.getOid());
    return message;
  }
  
}
