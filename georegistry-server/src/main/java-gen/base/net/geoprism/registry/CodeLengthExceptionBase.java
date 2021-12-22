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

@com.runwaysdk.business.ClassSignature(hash = 1138520491)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to CodeLengthException.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class CodeLengthExceptionBase extends com.runwaysdk.business.SmartException
{
  public final static String CLASS = "net.geoprism.registry.CodeLengthException";
  public static java.lang.String LENGTH = "length";
  public static java.lang.String OID = "oid";
  private static final long serialVersionUID = 1138520491;
  
  public CodeLengthExceptionBase()
  {
    super();
  }
  
  public CodeLengthExceptionBase(java.lang.String developerMessage)
  {
    super(developerMessage);
  }
  
  public CodeLengthExceptionBase(java.lang.String developerMessage, java.lang.Throwable cause)
  {
    super(developerMessage, cause);
  }
  
  public CodeLengthExceptionBase(java.lang.Throwable cause)
  {
    super(cause);
  }
  
  public Integer getLength()
  {
    return com.runwaysdk.constants.MdAttributeIntegerUtil.getTypeSafeValue(getValue(LENGTH));
  }
  
  public void validateLength()
  {
    this.validateAttribute(LENGTH);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeIntegerDAOIF getLengthMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.CodeLengthException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeIntegerDAOIF)mdClassIF.definesAttribute(LENGTH);
  }
  
  public void setLength(Integer value)
  {
    if(value == null)
    {
      setValue(LENGTH, "");
    }
    else
    {
      setValue(LENGTH, java.lang.Integer.toString(value));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.CodeLengthException.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public java.lang.String localize(java.util.Locale locale)
  {
    java.lang.String message = super.localize(locale);
    message = replace(message, "{length}", this.getLength());
    message = replace(message, "{oid}", this.getOid());
    return message;
  }
  
}
