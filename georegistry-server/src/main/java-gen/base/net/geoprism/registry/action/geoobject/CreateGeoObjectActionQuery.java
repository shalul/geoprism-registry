package net.geoprism.registry.action.geoobject;

@com.runwaysdk.business.ClassSignature(hash = -1651688585)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to CreateGeoObjectAction.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class CreateGeoObjectActionQuery extends net.geoprism.registry.action.AbstractActionQuery

{

  public CreateGeoObjectActionQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public CreateGeoObjectActionQuery(com.runwaysdk.query.ValueQuery valueQuery)
  {
    super(valueQuery);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = new com.runwaysdk.business.BusinessQuery(valueQuery, this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public String getClassType()
  {
    return net.geoprism.registry.action.geoobject.CreateGeoObjectAction.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getGeoObjectJson()
  {
    return getGeoObjectJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getParentJson()
  {
    return getParentJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, displayLabel);

  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends CreateGeoObjectAction> getIterator()
  {
    this.checkNotUsedInValueQuery();
    String sqlStmt;
    if (_limit != null && _skip != null)
    {
      sqlStmt = this.getComponentQuery().getSQL(_limit, _skip);
    }
    else
    {
      sqlStmt = this.getComponentQuery().getSQL();
    }
    java.util.Map<String, com.runwaysdk.query.ColumnInfo> columnInfoMap = this.getComponentQuery().getColumnInfoMap();

    java.sql.ResultSet results = com.runwaysdk.dataaccess.database.Database.query(sqlStmt);
    return new com.runwaysdk.business.BusinessIterator<CreateGeoObjectAction>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface CreateGeoObjectActionQueryReferenceIF extends net.geoprism.registry.action.AbstractActionQuery.AbstractActionQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getGeoObjectJson();
    public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias);
    public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getParentJson();
    public com.runwaysdk.query.SelectableChar getParentJson(String alias);
    public com.runwaysdk.query.SelectableChar getParentJson(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.action.geoobject.CreateGeoObjectAction createGeoObjectAction);

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.action.geoobject.CreateGeoObjectAction createGeoObjectAction);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class CreateGeoObjectActionQueryReference extends net.geoprism.registry.action.AbstractActionQuery.AbstractActionQueryReference
 implements CreateGeoObjectActionQueryReferenceIF

  {

  public CreateGeoObjectActionQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.action.geoobject.CreateGeoObjectAction createGeoObjectAction)
    {
      if(createGeoObjectAction == null) return this.EQ((java.lang.String)null);
      return this.EQ(createGeoObjectAction.getOid());
    }

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.action.geoobject.CreateGeoObjectAction createGeoObjectAction)
    {
      if(createGeoObjectAction == null) return this.NE((java.lang.String)null);
      return this.NE(createGeoObjectAction.getOid());
    }

  public com.runwaysdk.query.SelectableChar getGeoObjectJson()
  {
    return getGeoObjectJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getParentJson()
  {
    return getParentJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, displayLabel);

  }
  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface CreateGeoObjectActionQueryMultiReferenceIF extends net.geoprism.registry.action.AbstractActionQuery.AbstractActionQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getGeoObjectJson();
    public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias);
    public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getParentJson();
    public com.runwaysdk.query.SelectableChar getParentJson(String alias);
    public com.runwaysdk.query.SelectableChar getParentJson(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction);
    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction);
    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction);
    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction);
    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class CreateGeoObjectActionQueryMultiReference extends net.geoprism.registry.action.AbstractActionQuery.AbstractActionQueryMultiReference
 implements CreateGeoObjectActionQueryMultiReferenceIF

  {

  public CreateGeoObjectActionQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction)  {

      String[] itemIdArray = new String[createGeoObjectAction.length]; 

      for (int i=0; i<createGeoObjectAction.length; i++)
      {
        itemIdArray[i] = createGeoObjectAction[i].getOid();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction)  {

      String[] itemIdArray = new String[createGeoObjectAction.length]; 

      for (int i=0; i<createGeoObjectAction.length; i++)
      {
        itemIdArray[i] = createGeoObjectAction[i].getOid();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction)  {

      String[] itemIdArray = new String[createGeoObjectAction.length]; 

      for (int i=0; i<createGeoObjectAction.length; i++)
      {
        itemIdArray[i] = createGeoObjectAction[i].getOid();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction)  {

      String[] itemIdArray = new String[createGeoObjectAction.length]; 

      for (int i=0; i<createGeoObjectAction.length; i++)
      {
        itemIdArray[i] = createGeoObjectAction[i].getOid();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.action.geoobject.CreateGeoObjectAction ... createGeoObjectAction)  {

      String[] itemIdArray = new String[createGeoObjectAction.length]; 

      for (int i=0; i<createGeoObjectAction.length; i++)
      {
        itemIdArray[i] = createGeoObjectAction[i].getOid();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableChar getGeoObjectJson()
  {
    return getGeoObjectJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.GEOOBJECTJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getParentJson()
  {
    return getParentJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getParentJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.action.geoobject.CreateGeoObjectAction.PARENTJSON, alias, displayLabel);

  }
  }
}
