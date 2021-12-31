package net.geoprism.registry;

@com.runwaysdk.business.ClassSignature(hash = -2019382851)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to SingleListType.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class SingleListTypeBase extends net.geoprism.registry.ListType
{
  public final static String CLASS = "net.geoprism.registry.SingleListType";
  public static java.lang.String VALIDON = "validOn";
  private static final long serialVersionUID = -2019382851;
  
  public SingleListTypeBase()
  {
    super();
  }
  
  public java.util.Date getValidOn()
  {
    return com.runwaysdk.constants.MdAttributeDateTimeUtil.getTypeSafeValue(getValue(VALIDON));
  }
  
  public void validateValidOn()
  {
    this.validateAttribute(VALIDON);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF getValidOnMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.SingleListType.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDateTimeDAOIF)mdClassIF.definesAttribute(VALIDON);
  }
  
  public void setValidOn(java.util.Date value)
  {
    if(value == null)
    {
      setValue(VALIDON, "");
    }
    else
    {
      setValue(VALIDON, new java.text.SimpleDateFormat(com.runwaysdk.constants.Constants.DATETIME_FORMAT).format(value));
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static SingleListType get(String oid)
  {
    return (SingleListType) com.runwaysdk.business.Business.get(oid);
  }
  
  public static SingleListType getByKey(String key)
  {
    return (SingleListType) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static SingleListType lock(java.lang.String oid)
  {
    SingleListType _instance = SingleListType.get(oid);
    _instance.lock();
    
    return _instance;
  }
  
  public static SingleListType unlock(java.lang.String oid)
  {
    SingleListType _instance = SingleListType.get(oid);
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
