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

@com.runwaysdk.business.ClassSignature(hash = -337952040)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to MasterList.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class MasterListBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "net.geoprism.registry.MasterList";
  public static java.lang.String ACCESSCONSTRAINTSLOCAL = "accessConstraintsLocal";
  private com.runwaysdk.business.Struct accessConstraintsLocal = null;
  
  public static java.lang.String ACKNOWLEDGEMENTSLOCAL = "acknowledgementsLocal";
  private com.runwaysdk.business.Struct acknowledgementsLocal = null;
  
  public static java.lang.String CODE = "code";
  public static java.lang.String CONTACTNAME = "contactName";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String DESCRIPTIONLOCAL = "descriptionLocal";
  private com.runwaysdk.business.Struct descriptionLocal = null;
  
  public static java.lang.String DISCLAIMERLOCAL = "disclaimerLocal";
  private com.runwaysdk.business.Struct disclaimerLocal = null;
  
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String EMAIL = "email";
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String FREQUENCY = "frequency";
  public static java.lang.String HIERARCHIES = "hierarchies";
  public static java.lang.String ISMASTER = "isMaster";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String OID = "oid";
  public static java.lang.String ORGANIZATION = "organization";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String PROCESSLOCAL = "processLocal";
  private com.runwaysdk.business.Struct processLocal = null;
  
  public static java.lang.String PROGRESSLOCAL = "progressLocal";
  private com.runwaysdk.business.Struct progressLocal = null;
  
  public static java.lang.String PUBLISHDATE = "publishDate";
  public static java.lang.String PUBLISHINGSTARTDATE = "publishingStartDate";
  public static java.lang.String REPRESENTATIVITYDATE = "representativityDate";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String SUBTYPEHIERARCHIES = "subtypeHierarchies";
  public static java.lang.String TELEPHONENUMBER = "telephoneNumber";
  public static java.lang.String TYPE = "type";
  public static java.lang.String UNIVERSAL = "universal";
  public static java.lang.String USECONSTRAINTSLOCAL = "useConstraintsLocal";
  private com.runwaysdk.business.Struct useConstraintsLocal = null;
  
  public static java.lang.String VALID = "valid";
  public static java.lang.String VISIBILITY = "visibility";
  private static final long serialVersionUID = -337952040;
  
  public MasterListBase()
  {
    super();
    accessConstraintsLocal = super.getStruct("accessConstraintsLocal");
    acknowledgementsLocal = super.getStruct("acknowledgementsLocal");
    descriptionLocal = super.getStruct("descriptionLocal");
    disclaimerLocal = super.getStruct("disclaimerLocal");
    displayLabel = super.getStruct("displayLabel");
    processLocal = super.getStruct("processLocal");
    progressLocal = super.getStruct("progressLocal");
    useConstraintsLocal = super.getStruct("useConstraintsLocal");
  }
  
  public net.geoprism.registry.MasterListAccessConstraintsLocal getAccessConstraintsLocal()
  {
    return (net.geoprism.registry.MasterListAccessConstraintsLocal) accessConstraintsLocal;
  }
  
  public void validateAccessConstraintsLocal()
  {
    this.validateAttribute(ACCESSCONSTRAINTSLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getAccessConstraintsLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(ACCESSCONSTRAINTSLOCAL);
  }
  
  public net.geoprism.registry.MasterListAcknowledgementsLocal getAcknowledgementsLocal()
  {
    return (net.geoprism.registry.MasterListAcknowledgementsLocal) acknowledgementsLocal;
  }
  
  public void validateAcknowledgementsLocal()
  {
    this.validateAttribute(ACKNOWLEDGEMENTSLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getAcknowledgementsLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(ACKNOWLEDGEMENTSLOCAL);
  }
  
  public String getCode()
  {
    return getValue(CODE);
  }
  
  public void validateCode()
  {
    this.validateAttribute(CODE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getCodeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(CODE);
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
  
  public String getContactName()
  {
    return getValue(CONTACTNAME);
  }
  
  public void validateContactName()
  {
    this.validateAttribute(CONTACTNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getContactNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(CONTACTNAME);
  }
  
  public void setContactName(String value)
  {
    if(value == null)
    {
      setValue(CONTACTNAME, "");
    }
    else
    {
      setValue(CONTACTNAME, value);
    }
  }
  
  public java.util.Date getCreateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(CREATEDATE));
  }
  
  public void validateCreateDate()
  {
    this.validateAttribute(CREATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF getCreateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF)mdClassIF.definesAttribute(CREATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getCreatedBy()
  {
    if (getValue(CREATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(CREATEDBY));
    }
  }
  
  public String getCreatedByOid()
  {
    return getValue(CREATEDBY);
  }
  
  public void validateCreatedBy()
  {
    this.validateAttribute(CREATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getCreatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public net.geoprism.registry.MasterListDescriptionLocal getDescriptionLocal()
  {
    return (net.geoprism.registry.MasterListDescriptionLocal) descriptionLocal;
  }
  
  public void validateDescriptionLocal()
  {
    this.validateAttribute(DESCRIPTIONLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getDescriptionLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(DESCRIPTIONLOCAL);
  }
  
  public net.geoprism.registry.MasterListDisclaimerLocal getDisclaimerLocal()
  {
    return (net.geoprism.registry.MasterListDisclaimerLocal) disclaimerLocal;
  }
  
  public void validateDisclaimerLocal()
  {
    this.validateAttribute(DISCLAIMERLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getDisclaimerLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(DISCLAIMERLOCAL);
  }
  
  public net.geoprism.registry.MasterListDisplayLabel getDisplayLabel()
  {
    return (net.geoprism.registry.MasterListDisplayLabel) displayLabel;
  }
  
  public void validateDisplayLabel()
  {
    this.validateAttribute(DISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalCharacterDAOIF getDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalCharacterDAOIF)mdClassIF.definesAttribute(DISPLAYLABEL);
  }
  
  public String getEmail()
  {
    return getValue(EMAIL);
  }
  
  public void validateEmail()
  {
    this.validateAttribute(EMAIL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getEmailMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(EMAIL);
  }
  
  public void setEmail(String value)
  {
    if(value == null)
    {
      setValue(EMAIL, "");
    }
    else
    {
      setValue(EMAIL, value);
    }
  }
  
  public com.runwaysdk.system.metadata.MdDomain getEntityDomain()
  {
    if (getValue(ENTITYDOMAIN).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.metadata.MdDomain.get(getValue(ENTITYDOMAIN));
    }
  }
  
  public String getEntityDomainOid()
  {
    return getValue(ENTITYDOMAIN);
  }
  
  public void validateEntityDomain()
  {
    this.validateAttribute(ENTITYDOMAIN);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getEntityDomainMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(ENTITYDOMAIN);
  }
  
  public void setEntityDomain(com.runwaysdk.system.metadata.MdDomain value)
  {
    if(value == null)
    {
      setValue(ENTITYDOMAIN, "");
    }
    else
    {
      setValue(ENTITYDOMAIN, value.getOid());
    }
  }
  
  public void setEntityDomainId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(ENTITYDOMAIN, "");
    }
    else
    {
      setValue(ENTITYDOMAIN, oid);
    }
  }
  
  @SuppressWarnings("unchecked")
  public java.util.List<net.geoprism.registry.ChangeFrequency> getFrequency()
  {
    return (java.util.List<net.geoprism.registry.ChangeFrequency>) getEnumValues(FREQUENCY);
  }
  
  public void addFrequency(net.geoprism.registry.ChangeFrequency value)
  {
    if(value != null)
    {
      addEnumItem(FREQUENCY, value.getOid());
    }
  }
  
  public void removeFrequency(net.geoprism.registry.ChangeFrequency value)
  {
    if(value != null)
    {
      removeEnumItem(FREQUENCY, value.getOid());
    }
  }
  
  public void clearFrequency()
  {
    clearEnum(FREQUENCY);
  }
  
  public void validateFrequency()
  {
    this.validateAttribute(FREQUENCY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF getFrequencyMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdClassIF.definesAttribute(FREQUENCY);
  }
  
  public String getHierarchies()
  {
    return getValue(HIERARCHIES);
  }
  
  public void validateHierarchies()
  {
    this.validateAttribute(HIERARCHIES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getHierarchiesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(HIERARCHIES);
  }
  
  public void setHierarchies(String value)
  {
    if(value == null)
    {
      setValue(HIERARCHIES, "");
    }
    else
    {
      setValue(HIERARCHIES, value);
    }
  }
  
  public Boolean getIsMaster()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(ISMASTER));
  }
  
  public void validateIsMaster()
  {
    this.validateAttribute(ISMASTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeBooleanDAOIF getIsMasterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeBooleanDAOIF)mdClassIF.definesAttribute(ISMASTER);
  }
  
  public void setIsMaster(Boolean value)
  {
    if(value == null)
    {
      setValue(ISMASTER, "");
    }
    else
    {
      setValue(ISMASTER, java.lang.Boolean.toString(value));
    }
  }
  
  public String getKeyName()
  {
    return getValue(KEYNAME);
  }
  
  public void validateKeyName()
  {
    this.validateAttribute(KEYNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getKeyNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(KEYNAME);
  }
  
  public void setKeyName(String value)
  {
    if(value == null)
    {
      setValue(KEYNAME, "");
    }
    else
    {
      setValue(KEYNAME, value);
    }
  }
  
  public java.util.Date getLastUpdateDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(LASTUPDATEDATE));
  }
  
  public void validateLastUpdateDate()
  {
    this.validateAttribute(LASTUPDATEDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF getLastUpdateDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF)mdClassIF.definesAttribute(LASTUPDATEDATE);
  }
  
  public com.runwaysdk.system.SingleActor getLastUpdatedBy()
  {
    if (getValue(LASTUPDATEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(LASTUPDATEDBY));
    }
  }
  
  public String getLastUpdatedByOid()
  {
    return getValue(LASTUPDATEDBY);
  }
  
  public void validateLastUpdatedBy()
  {
    this.validateAttribute(LASTUPDATEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getLastUpdatedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(LASTUPDATEDBY);
  }
  
  public com.runwaysdk.system.SingleActor getLockedBy()
  {
    if (getValue(LOCKEDBY).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(LOCKEDBY));
    }
  }
  
  public String getLockedByOid()
  {
    return getValue(LOCKEDBY);
  }
  
  public void validateLockedBy()
  {
    this.validateAttribute(LOCKEDBY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getLockedByMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(LOCKEDBY);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
  }
  
  public net.geoprism.registry.Organization getOrganization()
  {
    if (getValue(ORGANIZATION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return net.geoprism.registry.Organization.get(getValue(ORGANIZATION));
    }
  }
  
  public String getOrganizationOid()
  {
    return getValue(ORGANIZATION);
  }
  
  public void validateOrganization()
  {
    this.validateAttribute(ORGANIZATION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getOrganizationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(ORGANIZATION);
  }
  
  public void setOrganization(net.geoprism.registry.Organization value)
  {
    if(value == null)
    {
      setValue(ORGANIZATION, "");
    }
    else
    {
      setValue(ORGANIZATION, value.getOid());
    }
  }
  
  public void setOrganizationId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(ORGANIZATION, "");
    }
    else
    {
      setValue(ORGANIZATION, oid);
    }
  }
  
  public com.runwaysdk.system.Actor getOwner()
  {
    if (getValue(OWNER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.Actor.get(getValue(OWNER));
    }
  }
  
  public String getOwnerOid()
  {
    return getValue(OWNER);
  }
  
  public void validateOwner()
  {
    this.validateAttribute(OWNER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getOwnerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(OWNER);
  }
  
  public void setOwner(com.runwaysdk.system.Actor value)
  {
    if(value == null)
    {
      setValue(OWNER, "");
    }
    else
    {
      setValue(OWNER, value.getOid());
    }
  }
  
  public void setOwnerId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(OWNER, "");
    }
    else
    {
      setValue(OWNER, oid);
    }
  }
  
  public net.geoprism.registry.MasterListProcessLocal getProcessLocal()
  {
    return (net.geoprism.registry.MasterListProcessLocal) processLocal;
  }
  
  public void validateProcessLocal()
  {
    this.validateAttribute(PROCESSLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getProcessLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(PROCESSLOCAL);
  }
  
  public net.geoprism.registry.MasterListProgressLocal getProgressLocal()
  {
    return (net.geoprism.registry.MasterListProgressLocal) progressLocal;
  }
  
  public void validateProgressLocal()
  {
    this.validateAttribute(PROGRESSLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getProgressLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(PROGRESSLOCAL);
  }
  
  public java.util.Date getPublishDate()
  {
    return com.runwaysdk.constants.MdAttributeDateUtil.getTypeSafeValue(getValue(PUBLISHDATE));
  }
  
  public void validatePublishDate()
  {
    this.validateAttribute(PUBLISHDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateDAOIF getPublishDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateDAOIF)mdClassIF.definesAttribute(PUBLISHDATE);
  }
  
  public void setPublishDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(PUBLISHDATE, "");
    }
    else
    {
      setValue(PUBLISHDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATE_FORMAT).format(value));
    }
  }
  
  public java.util.Date getPublishingStartDate()
  {
    return com.runwaysdk.constants.MdAttributeDateUtil.getTypeSafeValue(getValue(PUBLISHINGSTARTDATE));
  }
  
  public void validatePublishingStartDate()
  {
    this.validateAttribute(PUBLISHINGSTARTDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateDAOIF getPublishingStartDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateDAOIF)mdClassIF.definesAttribute(PUBLISHINGSTARTDATE);
  }
  
  public void setPublishingStartDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(PUBLISHINGSTARTDATE, "");
    }
    else
    {
      setValue(PUBLISHINGSTARTDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATE_FORMAT).format(value));
    }
  }
  
  public java.util.Date getRepresentativityDate()
  {
    return com.runwaysdk.constants.MdAttributeDateUtil.getTypeSafeValue(getValue(REPRESENTATIVITYDATE));
  }
  
  public void validateRepresentativityDate()
  {
    this.validateAttribute(REPRESENTATIVITYDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateDAOIF getRepresentativityDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateDAOIF)mdClassIF.definesAttribute(REPRESENTATIVITYDATE);
  }
  
  public void setRepresentativityDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(REPRESENTATIVITYDATE, "");
    }
    else
    {
      setValue(REPRESENTATIVITYDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATE_FORMAT).format(value));
    }
  }
  
  public Long getSeq()
  {
    return com.runwaysdk.constants.MdAttributeLongUtil.getTypeSafeValue(getValue(SEQ));
  }
  
  public void validateSeq()
  {
    this.validateAttribute(SEQ);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLongDAOIF getSeqMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLongDAOIF)mdClassIF.definesAttribute(SEQ);
  }
  
  public String getSiteMaster()
  {
    return getValue(SITEMASTER);
  }
  
  public void validateSiteMaster()
  {
    this.validateAttribute(SITEMASTER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getSiteMasterMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(SITEMASTER);
  }
  
  public String getSubtypeHierarchies()
  {
    return getValue(SUBTYPEHIERARCHIES);
  }
  
  public void validateSubtypeHierarchies()
  {
    this.validateAttribute(SUBTYPEHIERARCHIES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getSubtypeHierarchiesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(SUBTYPEHIERARCHIES);
  }
  
  public void setSubtypeHierarchies(String value)
  {
    if(value == null)
    {
      setValue(SUBTYPEHIERARCHIES, "");
    }
    else
    {
      setValue(SUBTYPEHIERARCHIES, value);
    }
  }
  
  public String getTelephoneNumber()
  {
    return getValue(TELEPHONENUMBER);
  }
  
  public void validateTelephoneNumber()
  {
    this.validateAttribute(TELEPHONENUMBER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getTelephoneNumberMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(TELEPHONENUMBER);
  }
  
  public void setTelephoneNumber(String value)
  {
    if(value == null)
    {
      setValue(TELEPHONENUMBER, "");
    }
    else
    {
      setValue(TELEPHONENUMBER, value);
    }
  }
  
  public String getType()
  {
    return getValue(TYPE);
  }
  
  public void validateType()
  {
    this.validateAttribute(TYPE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getTypeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(TYPE);
  }
  
  public com.runwaysdk.system.gis.geo.Universal getUniversal()
  {
    if (getValue(UNIVERSAL).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.gis.geo.Universal.get(getValue(UNIVERSAL));
    }
  }
  
  public String getUniversalOid()
  {
    return getValue(UNIVERSAL);
  }
  
  public void validateUniversal()
  {
    this.validateAttribute(UNIVERSAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getUniversalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(UNIVERSAL);
  }
  
  public void setUniversal(com.runwaysdk.system.gis.geo.Universal value)
  {
    if(value == null)
    {
      setValue(UNIVERSAL, "");
    }
    else
    {
      setValue(UNIVERSAL, value.getOid());
    }
  }
  
  public void setUniversalId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(UNIVERSAL, "");
    }
    else
    {
      setValue(UNIVERSAL, oid);
    }
  }
  
  public net.geoprism.registry.MasterListUseConstraintsLocal getUseConstraintsLocal()
  {
    return (net.geoprism.registry.MasterListUseConstraintsLocal) useConstraintsLocal;
  }
  
  public void validateUseConstraintsLocal()
  {
    this.validateAttribute(USECONSTRAINTSLOCAL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getUseConstraintsLocalMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(USECONSTRAINTSLOCAL);
  }
  
  public Boolean getValid()
  {
    return com.runwaysdk.constants.MdAttributeBooleanUtil.getTypeSafeValue(getValue(VALID));
  }
  
  public void validateValid()
  {
    this.validateAttribute(VALID);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeBooleanDAOIF getValidMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeBooleanDAOIF)mdClassIF.definesAttribute(VALID);
  }
  
  public void setValid(Boolean value)
  {
    if(value == null)
    {
      setValue(VALID, "");
    }
    else
    {
      setValue(VALID, java.lang.Boolean.toString(value));
    }
  }
  
  public String getVisibility()
  {
    return getValue(VISIBILITY);
  }
  
  public void validateVisibility()
  {
    this.validateAttribute(VISIBILITY);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getVisibilityMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.MasterList.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(VISIBILITY);
  }
  
  public void setVisibility(String value)
  {
    if(value == null)
    {
      setValue(VISIBILITY, "");
    }
    else
    {
      setValue(VISIBILITY, value);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static MasterListQuery getAllInstances(String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    MasterListQuery query = new MasterListQuery(new com.runwaysdk.query.QueryFactory());
    com.runwaysdk.business.Entity.getAllInstances(query, sortAttribute, ascending, pageSize, pageNumber);
    return query;
  }
  
  public static MasterList get(String oid)
  {
    return (MasterList) com.runwaysdk.business.Business.get(oid);
  }
  
  public static MasterList getByKey(String key)
  {
    return (MasterList) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public net.geoprism.registry.MasterListVersion createVersion(java.util.Date forDate, java.lang.String versionType)
  {
    String msg = "This method should never be invoked.  It should be overwritten in net.geoprism.registry.MasterList.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static final net.geoprism.registry.MasterListVersion createVersion(java.lang.String oid, java.util.Date forDate, java.lang.String versionType)
  {
    MasterList _instance = MasterList.get(oid);
    return _instance.createVersion(forDate, versionType);
  }
  
  public static MasterList lock(java.lang.String oid)
  {
    MasterList _instance = MasterList.get(oid);
    _instance.lock();
    
    return _instance;
  }
  
  public static MasterList unlock(java.lang.String oid)
  {
    MasterList _instance = MasterList.get(oid);
    _instance.unlock();
    
    return _instance;
  }
  
  public String toString()
  {
    if (this.isNew())
    {
      return "New: "+ this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
