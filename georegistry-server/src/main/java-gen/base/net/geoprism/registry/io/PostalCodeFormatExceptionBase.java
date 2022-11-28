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
package net.geoprism.registry.io;

@com.runwaysdk.business.ClassSignature(hash = -2057356685)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to PostalCodeFormatException.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class PostalCodeFormatExceptionBase extends com.runwaysdk.business.SmartException
{
  public final static String CLASS = "net.geoprism.registry.io.PostalCodeFormatException";
  public static final java.lang.String CODE = "code";
  public static final java.lang.String OID = "oid";
  public static final java.lang.String TYPELABEL = "typeLabel";
  private static final long serialVersionUID = -2057356685;
  
  public PostalCodeFormatExceptionBase()
  {
    super();
  }
  
  public PostalCodeFormatExceptionBase(java.lang.String developerMessage)
  {
    super(developerMessage);
  }
  
  public PostalCodeFormatExceptionBase(java.lang.String developerMessage, java.lang.Throwable cause)
  {
    super(developerMessage, cause);
  }
  
  public PostalCodeFormatExceptionBase(java.lang.Throwable cause)
  {
    super(cause);
  }
  
  public String getCode()
  {
    return getValue(CODE);
  }
  
  public void validateCode()
  {
    this.validateAttribute(CODE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getCodeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.io.PostalCodeFormatException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(CODE);
  }
  
  public void setCode(String value)
  {
    if(value == null)
    {
      setValue(CODE, "");
    }
    else
    {
      setValue(CODE, value);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.io.PostalCodeFormatException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
  }
  
  public String getTypeLabel()
  {
    return getValue(TYPELABEL);
  }
  
  public void validateTypeLabel()
  {
    this.validateAttribute(TYPELABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getTypeLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.io.PostalCodeFormatException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(TYPELABEL);
  }
  
  public void setTypeLabel(String value)
  {
    if(value == null)
    {
      setValue(TYPELABEL, "");
    }
    else
    {
      setValue(TYPELABEL, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public java.lang.String localize(java.util.Locale locale)
  {
    java.lang.String message = super.localize(locale);
    message = replace(message, "{code}", this.getCode());
    message = replace(message, "{oid}", this.getOid());
    message = replace(message, "{typeLabel}", this.getTypeLabel());
    return message;
  }
  
}
