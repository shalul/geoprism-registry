package net.geoprism.registry;

@com.runwaysdk.business.ClassSignature(hash = 383602473)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ListTypeListProcess.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ListTypeListProcessBase extends com.runwaysdk.business.LocalStruct
{
  public final static String CLASS = "net.geoprism.registry.ListTypeListProcess";
  public static java.lang.String DEFAULTLOCALE = "defaultLocale";
  public static java.lang.String KEYNAME = "keyName";
  public static java.lang.String OID = "oid";
  public static java.lang.String SITEMASTER = "siteMaster";
  private static final long serialVersionUID = 383602473;
  
  public ListTypeListProcessBase()
  {
    super();
  }
  
  public ListTypeListProcessBase(com.runwaysdk.business.MutableWithStructs component, String structName)
  {
    super(component, structName);
  }
  
  public static ListTypeListProcess get(String oid)
  {
    return (ListTypeListProcess) com.runwaysdk.business.Struct.get(oid);
  }
  
  public static ListTypeListProcess getByKey(String key)
  {
    return (ListTypeListProcess) com.runwaysdk.business.Struct.get(CLASS, key);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListTypeListProcess.CLASS);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListTypeListProcess.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF)mdClassIF.definesAttribute(OID);
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
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.ListTypeListProcess.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF)mdClassIF.definesAttribute(SITEMASTER);
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static ListTypeListProcessQuery getAllInstances(String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    ListTypeListProcessQuery query = new ListTypeListProcessQuery(new com.runwaysdk.query.QueryFactory());
    com.runwaysdk.business.Entity.getAllInstances(query, sortAttribute, ascending, pageSize, pageNumber);
    return query;
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
