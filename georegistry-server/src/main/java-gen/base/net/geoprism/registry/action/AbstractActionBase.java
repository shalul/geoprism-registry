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
package net.geoprism.registry.action;

@com.runwaysdk.business.ClassSignature(hash = 1066881005)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to AbstractAction.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class AbstractActionBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "net.geoprism.registry.action.AbstractAction";
  public static final java.lang.String ADDITIONALNOTES = "additionalNotes";
  public static final java.lang.String APIVERSION = "apiVersion";
  public static final java.lang.String APPROVALSTATUS = "approvalStatus";
  public static final java.lang.String CONTRIBUTORNOTES = "contributorNotes";
  public static final java.lang.String CREATEACTIONDATE = "createActionDate";
  public static final java.lang.String CREATEDATE = "createDate";
  public static final java.lang.String CREATEDBY = "createdBy";
  public static final java.lang.String DECISIONMAKER = "decisionMaker";
  public static final java.lang.String ENTITYDOMAIN = "entityDomain";
  public static final java.lang.String KEYNAME = "keyName";
  public static final java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static final java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static final java.lang.String LOCKEDBY = "lockedBy";
  public static final java.lang.String MAINTAINERNOTES = "maintainerNotes";
  public static final java.lang.String OID = "oid";
  public static final java.lang.String OWNER = "owner";
  public static final java.lang.String SEQ = "seq";
  public static final java.lang.String SITEMASTER = "siteMaster";
  public static final java.lang.String TYPE = "type";
  private static final long serialVersionUID = 1066881005;
  
  public AbstractActionBase()
  {
    super();
  }
  
  public String getAdditionalNotes()
  {
    return getValue(ADDITIONALNOTES);
  }
  
  public void validateAdditionalNotes()
  {
    this.validateAttribute(ADDITIONALNOTES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getAdditionalNotesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(ADDITIONALNOTES);
  }
  
  public void setAdditionalNotes(String value)
  {
    if(value == null)
    {
      setValue(ADDITIONALNOTES, "");
    }
    else
    {
      setValue(ADDITIONALNOTES, value);
    }
  }
  
  public String getApiVersion()
  {
    return getValue(APIVERSION);
  }
  
  public void validateApiVersion()
  {
    this.validateAttribute(APIVERSION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getApiVersionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(APIVERSION);
  }
  
  public void setApiVersion(String value)
  {
    if(value == null)
    {
      setValue(APIVERSION, "");
    }
    else
    {
      setValue(APIVERSION, value);
    }
  }
  
  
  public java.util.List<net.geoprism.registry.action.AllGovernanceStatus> getApprovalStatus()
  {
    return (java.util.List<net.geoprism.registry.action.AllGovernanceStatus>) getEnumValues(APPROVALSTATUS);
  }
  
  public void addApprovalStatus(net.geoprism.registry.action.AllGovernanceStatus value)
  {
    if(value != null)
    {
      addEnumItem(APPROVALSTATUS, value.getOid());
    }
  }
  
  public void removeApprovalStatus(net.geoprism.registry.action.AllGovernanceStatus value)
  {
    if(value != null)
    {
      removeEnumItem(APPROVALSTATUS, value.getOid());
    }
  }
  
  public void clearApprovalStatus()
  {
    clearEnum(APPROVALSTATUS);
  }
  
  public void validateApprovalStatus()
  {
    this.validateAttribute(APPROVALSTATUS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF getApprovalStatusMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdClassIF.definesAttribute(APPROVALSTATUS);
  }
  
  public String getContributorNotes()
  {
    return getValue(CONTRIBUTORNOTES);
  }
  
  public void validateContributorNotes()
  {
    this.validateAttribute(CONTRIBUTORNOTES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getContributorNotesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(CONTRIBUTORNOTES);
  }
  
  public void setContributorNotes(String value)
  {
    if(value == null)
    {
      setValue(CONTRIBUTORNOTES, "");
    }
    else
    {
      setValue(CONTRIBUTORNOTES, value);
    }
  }
  
  public java.util.Date getCreateActionDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(CREATEACTIONDATE));
  }
  
  public void validateCreateActionDate()
  {
    this.validateAttribute(CREATEACTIONDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF getCreateActionDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF)mdClassIF.definesAttribute(CREATEACTIONDATE);
  }
  
  public void setCreateActionDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(CREATEACTIONDATE, "");
    }
    else
    {
      setValue(CREATEACTIONDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public com.runwaysdk.system.SingleActor getDecisionMaker()
  {
    if (getValue(DECISIONMAKER).trim().equals(""))
    {
      return null;
    }
    else
    {
      return com.runwaysdk.system.SingleActor.get(getValue(DECISIONMAKER));
    }
  }
  
  public String getDecisionMakerOid()
  {
    return getValue(DECISIONMAKER);
  }
  
  public void validateDecisionMaker()
  {
    this.validateAttribute(DECISIONMAKER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getDecisionMakerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(DECISIONMAKER);
  }
  
  public void setDecisionMaker(com.runwaysdk.system.SingleActor value)
  {
    if(value == null)
    {
      setValue(DECISIONMAKER, "");
    }
    else
    {
      setValue(DECISIONMAKER, value.getOid());
    }
  }
  
  public void setDecisionMakerId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(DECISIONMAKER, "");
    }
    else
    {
      setValue(DECISIONMAKER, oid);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(LOCKEDBY);
  }
  
  public String getMaintainerNotes()
  {
    return getValue(MAINTAINERNOTES);
  }
  
  public void validateMaintainerNotes()
  {
    this.validateAttribute(MAINTAINERNOTES);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getMaintainerNotesMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(MAINTAINERNOTES);
  }
  
  public void setMaintainerNotes(String value)
  {
    if(value == null)
    {
      setValue(MAINTAINERNOTES, "");
    }
    else
    {
      setValue(MAINTAINERNOTES, value);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(SITEMASTER);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.action.AbstractAction.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(TYPE);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public net.geoprism.registry.action.ActionHasDocument addDocument(com.runwaysdk.system.VaultFile vaultFile)
  {
    return (net.geoprism.registry.action.ActionHasDocument) addChild(vaultFile, net.geoprism.registry.action.ActionHasDocument.CLASS);
  }
  
  public void removeDocument(com.runwaysdk.system.VaultFile vaultFile)
  {
    removeAllChildren(vaultFile, net.geoprism.registry.action.ActionHasDocument.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.VaultFile> getAllDocument()
  {
    return (com.runwaysdk.query.OIterator<? extends com.runwaysdk.system.VaultFile>) getChildren(net.geoprism.registry.action.ActionHasDocument.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ActionHasDocument> getAllDocumentRel()
  {
    return (com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ActionHasDocument>) getChildRelationships(net.geoprism.registry.action.ActionHasDocument.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ActionHasDocument> getDocumentRel(com.runwaysdk.system.VaultFile vaultFile)
  {
    return (com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ActionHasDocument>) getRelationshipsWithChild(vaultFile, net.geoprism.registry.action.ActionHasDocument.CLASS);
  }
  
  public net.geoprism.registry.action.HasActionRelationship addRequest(net.geoprism.registry.action.ChangeRequest changeRequest)
  {
    return (net.geoprism.registry.action.HasActionRelationship) addParent(changeRequest, net.geoprism.registry.action.HasActionRelationship.CLASS);
  }
  
  public void removeRequest(net.geoprism.registry.action.ChangeRequest changeRequest)
  {
    removeAllParents(changeRequest, net.geoprism.registry.action.HasActionRelationship.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ChangeRequest> getAllRequest()
  {
    return (com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.ChangeRequest>) getParents(net.geoprism.registry.action.HasActionRelationship.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.HasActionRelationship> getAllRequestRel()
  {
    return (com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.HasActionRelationship>) getParentRelationships(net.geoprism.registry.action.HasActionRelationship.CLASS);
  }
  
  
  public com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.HasActionRelationship> getRequestRel(net.geoprism.registry.action.ChangeRequest changeRequest)
  {
    return (com.runwaysdk.query.OIterator<? extends net.geoprism.registry.action.HasActionRelationship>) getRelationshipsWithParent(changeRequest, net.geoprism.registry.action.HasActionRelationship.CLASS);
  }
  
  public static AbstractAction get(String oid)
  {
    return (AbstractAction) com.runwaysdk.business.Business.get(oid);
  }
  
  public static AbstractAction getByKey(String key)
  {
    return (AbstractAction) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static AbstractAction lock(java.lang.String oid)
  {
    AbstractAction _instance = AbstractAction.get(oid);
    _instance.lock();
    
    return _instance;
  }
  
  public static AbstractAction unlock(java.lang.String oid)
  {
    AbstractAction _instance = AbstractAction.get(oid);
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
