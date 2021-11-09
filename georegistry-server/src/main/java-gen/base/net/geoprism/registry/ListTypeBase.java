package net.geoprism.registry;

@com.runwaysdk.business.ClassSignature(hash = 1599626454)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ListType.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ListTypeBase extends com.runwaysdk.business.Business
{
  public final static String CLASS = "net.geoprism.registry.ListType";
  public static java.lang.String CODE = "code";
  public static java.lang.String CREATEDATE = "createDate";
  public static java.lang.String CREATEDBY = "createdBy";
  public static java.lang.String DESCRIPTION = "description";
  private com.runwaysdk.business.Struct description = null;
  
  public static java.lang.String DISPLAYLABEL = "displayLabel";
  private com.runwaysdk.business.Struct displayLabel = null;
  
  public static java.lang.String ENTITYDOMAIN = "entityDomain";
  public static java.lang.String HIERARCHIES = "hierarchies";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String LASTUPDATEDATE = "lastUpdateDate";
  public static java.lang.String LASTUPDATEDBY = "lastUpdatedBy";
  public static java.lang.String LISTACCESSCONSTRAINTS = "listAccessConstraints";
  private com.runwaysdk.business.Struct listAccessConstraints = null;
  
  public static java.lang.String LISTACKNOWLEDGEMENTS = "listAcknowledgements";
  private com.runwaysdk.business.Struct listAcknowledgements = null;
  
  public static java.lang.String LISTCOLLECTIONDATE = "listCollectionDate";
  public static java.lang.String LISTCONTACTNAME = "listContactName";
  public static java.lang.String LISTDESCRIPTION = "listDescription";
  private com.runwaysdk.business.Struct listDescription = null;
  
  public static java.lang.String LISTDISCLAIMER = "listDisclaimer";
  private com.runwaysdk.business.Struct listDisclaimer = null;
  
  public static java.lang.String LISTEMAIL = "listEmail";
  public static java.lang.String LISTLABEL = "listLabel";
  private com.runwaysdk.business.Struct listLabel = null;
  
  public static java.lang.String LISTORGANIZATION = "listOrganization";
  public static java.lang.String LISTORIGINATOR = "listOriginator";
  public static java.lang.String LISTPROCESS = "listProcess";
  private com.runwaysdk.business.Struct listProcess = null;
  
  public static java.lang.String LISTPROGRESS = "listProgress";
  private com.runwaysdk.business.Struct listProgress = null;
  
  public static java.lang.String LISTTELEPHONENUMBER = "listTelephoneNumber";
  public static java.lang.String LISTUSECONSTRAINTS = "listUseConstraints";
  private com.runwaysdk.business.Struct listUseConstraints = null;
  
  public static java.lang.String LOCKEDBY = "lockedBy";
  public static java.lang.String OID = "oid";
  public static java.lang.String ORGANIZATION = "organization";
  public static java.lang.String OWNER = "owner";
  public static java.lang.String SEQ = "seq";
  public static java.lang.String SITEMASTER = "siteMaster";
  public static java.lang.String SUBTYPEHIERARCHIES = "subtypeHierarchies";
  public static java.lang.String TYPE = "type";
  public static java.lang.String UNIVERSAL = "universal";
  public static java.lang.String VALID = "valid";
  private static final long serialVersionUID = 1599626454;
  
  public ListTypeBase()
  {
    super();
    description = super.getStruct("description");
    displayLabel = super.getStruct("displayLabel");
    listAccessConstraints = super.getStruct("listAccessConstraints");
    listAcknowledgements = super.getStruct("listAcknowledgements");
    listDescription = super.getStruct("listDescription");
    listDisclaimer = super.getStruct("listDisclaimer");
    listLabel = super.getStruct("listLabel");
    listProcess = super.getStruct("listProcess");
    listProgress = super.getStruct("listProgress");
    listUseConstraints = super.getStruct("listUseConstraints");
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(CREATEDBY);
  }
  
  public net.geoprism.registry.ListTypeDescription getDescription()
  {
    return (net.geoprism.registry.ListTypeDescription) description;
  }
  
  public void validateDescription()
  {
    this.validateAttribute(DESCRIPTION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getDescriptionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(DESCRIPTION);
  }
  
  public net.geoprism.registry.ListTypeDisplayLabel getDisplayLabel()
  {
    return (net.geoprism.registry.ListTypeDisplayLabel) displayLabel;
  }
  
  public void validateDisplayLabel()
  {
    this.validateAttribute(DISPLAYLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalCharacterDAOIF getDisplayLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalCharacterDAOIF)mdClassIF.definesAttribute(DISPLAYLABEL);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(LASTUPDATEDBY);
  }
  
  public net.geoprism.registry.ListTypeListAccessConstraints getListAccessConstraints()
  {
    return (net.geoprism.registry.ListTypeListAccessConstraints) listAccessConstraints;
  }
  
  public void validateListAccessConstraints()
  {
    this.validateAttribute(LISTACCESSCONSTRAINTS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListAccessConstraintsMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTACCESSCONSTRAINTS);
  }
  
  public net.geoprism.registry.ListTypeListAcknowledgements getListAcknowledgements()
  {
    return (net.geoprism.registry.ListTypeListAcknowledgements) listAcknowledgements;
  }
  
  public void validateListAcknowledgements()
  {
    this.validateAttribute(LISTACKNOWLEDGEMENTS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListAcknowledgementsMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTACKNOWLEDGEMENTS);
  }
  
  public java.util.Date getListCollectionDate()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(LISTCOLLECTIONDATE));
  }
  
  public void validateListCollectionDate()
  {
    this.validateAttribute(LISTCOLLECTIONDATE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF getListCollectionDateMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF)mdClassIF.definesAttribute(LISTCOLLECTIONDATE);
  }
  
  public void setListCollectionDate(java.util.Date value)
  {
    if(value == null)
    {
      setValue(LISTCOLLECTIONDATE, "");
    }
    else
    {
      setValue(LISTCOLLECTIONDATE, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
    }
  }
  
  public String getListContactName()
  {
    return getValue(LISTCONTACTNAME);
  }
  
  public void validateListContactName()
  {
    this.validateAttribute(LISTCONTACTNAME);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getListContactNameMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(LISTCONTACTNAME);
  }
  
  public void setListContactName(String value)
  {
    if(value == null)
    {
      setValue(LISTCONTACTNAME, "");
    }
    else
    {
      setValue(LISTCONTACTNAME, value);
    }
  }
  
  public net.geoprism.registry.ListTypeListDescription getListDescription()
  {
    return (net.geoprism.registry.ListTypeListDescription) listDescription;
  }
  
  public void validateListDescription()
  {
    this.validateAttribute(LISTDESCRIPTION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListDescriptionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTDESCRIPTION);
  }
  
  public net.geoprism.registry.ListTypeListDisclaimer getListDisclaimer()
  {
    return (net.geoprism.registry.ListTypeListDisclaimer) listDisclaimer;
  }
  
  public void validateListDisclaimer()
  {
    this.validateAttribute(LISTDISCLAIMER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListDisclaimerMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTDISCLAIMER);
  }
  
  public String getListEmail()
  {
    return getValue(LISTEMAIL);
  }
  
  public void validateListEmail()
  {
    this.validateAttribute(LISTEMAIL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getListEmailMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(LISTEMAIL);
  }
  
  public void setListEmail(String value)
  {
    if(value == null)
    {
      setValue(LISTEMAIL, "");
    }
    else
    {
      setValue(LISTEMAIL, value);
    }
  }
  
  public net.geoprism.registry.ListTypeListLabel getListLabel()
  {
    return (net.geoprism.registry.ListTypeListLabel) listLabel;
  }
  
  public void validateListLabel()
  {
    this.validateAttribute(LISTLABEL);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTLABEL);
  }
  
  public String getListOrganization()
  {
    return getValue(LISTORGANIZATION);
  }
  
  public void validateListOrganization()
  {
    this.validateAttribute(LISTORGANIZATION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getListOrganizationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(LISTORGANIZATION);
  }
  
  public void setListOrganization(String value)
  {
    if(value == null)
    {
      setValue(LISTORGANIZATION, "");
    }
    else
    {
      setValue(LISTORGANIZATION, value);
    }
  }
  
  public String getListOriginator()
  {
    return getValue(LISTORIGINATOR);
  }
  
  public void validateListOriginator()
  {
    this.validateAttribute(LISTORIGINATOR);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getListOriginatorMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(LISTORIGINATOR);
  }
  
  public void setListOriginator(String value)
  {
    if(value == null)
    {
      setValue(LISTORIGINATOR, "");
    }
    else
    {
      setValue(LISTORIGINATOR, value);
    }
  }
  
  public net.geoprism.registry.ListTypeListProcess getListProcess()
  {
    return (net.geoprism.registry.ListTypeListProcess) listProcess;
  }
  
  public void validateListProcess()
  {
    this.validateAttribute(LISTPROCESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListProcessMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTPROCESS);
  }
  
  public net.geoprism.registry.ListTypeListProgress getListProgress()
  {
    return (net.geoprism.registry.ListTypeListProgress) listProgress;
  }
  
  public void validateListProgress()
  {
    this.validateAttribute(LISTPROGRESS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListProgressMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTPROGRESS);
  }
  
  public String getListTelephoneNumber()
  {
    return getValue(LISTTELEPHONENUMBER);
  }
  
  public void validateListTelephoneNumber()
  {
    this.validateAttribute(LISTTELEPHONENUMBER);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeTextDAOIF getListTelephoneNumberMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeTextDAOIF)mdClassIF.definesAttribute(LISTTELEPHONENUMBER);
  }
  
  public void setListTelephoneNumber(String value)
  {
    if(value == null)
    {
      setValue(LISTTELEPHONENUMBER, "");
    }
    else
    {
      setValue(LISTTELEPHONENUMBER, value);
    }
  }
  
  public net.geoprism.registry.ListTypeListUseConstraints getListUseConstraints()
  {
    return (net.geoprism.registry.ListTypeListUseConstraints) listUseConstraints;
  }
  
  public void validateListUseConstraints()
  {
    this.validateAttribute(LISTUSECONSTRAINTS);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF getListUseConstraintsMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLocalTextDAOIF)mdClassIF.definesAttribute(LISTUSECONSTRAINTS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListType.CLASS);
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
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static ListType get(String oid)
  {
    return (ListType) com.runwaysdk.business.Business.get(oid);
  }
  
  public static ListType getByKey(String key)
  {
    return (ListType) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public net.geoprism.registry.ListTypeEntry createEntry(java.util.Date forDate)
  {
    String msg = "This method should never be invoked.  It should be overwritten in net.geoprism.registry.ListType.java";
    throw new com.runwaysdk.dataaccess.metadata.ForbiddenMethodException(msg);
  }
  
  public static final net.geoprism.registry.ListTypeEntry createEntry(java.lang.String oid, java.util.Date forDate)
  {
    ListType _instance = ListType.get(oid);
    return _instance.createEntry(forDate);
  }
  
  public static ListType lock(java.lang.String oid)
  {
    ListType _instance = ListType.get(oid);
    _instance.lock();
    
    return _instance;
  }
  
  public static ListType unlock(java.lang.String oid)
  {
    ListType _instance = ListType.get(oid);
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
