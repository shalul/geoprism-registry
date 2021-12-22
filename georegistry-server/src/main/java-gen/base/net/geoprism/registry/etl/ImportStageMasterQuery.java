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
package net.geoprism.registry.etl;

@com.runwaysdk.business.ClassSignature(hash = -230987384)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ImportStageMaster.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class ImportStageMasterQuery extends com.runwaysdk.system.EnumerationMasterQuery

{

  public ImportStageMasterQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public ImportStageMasterQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return net.geoprism.registry.etl.ImportStageMaster.CLASS;
  }
  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends ImportStageMaster> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<ImportStageMaster>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * 
 **/

  public com.runwaysdk.query.Condition enum_ImportStage()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EnumerationAttributeItem.CLASS);

    com.runwaysdk.business.BusinessQuery businessQuery = queryFactory.businessQuery(com.runwaysdk.system.metadata.MdEnumeration.CLASS);
    com.runwaysdk.dataaccess.MdEnumerationDAOIF mdEnumerationIF = com.runwaysdk.dataaccess.metadata.MdEnumerationDAO.getMdEnumerationDAO(net.geoprism.registry.etl.ImportStage.CLASS); 
    businessQuery.WHERE(businessQuery.oid().EQ(mdEnumerationIF.getOid()));

    relationshipQuery.WHERE(relationshipQuery.hasParent(businessQuery));

    return this.getBusinessQuery().isChildIn(relationshipQuery);
  }


/**
 * 
 **/

  public com.runwaysdk.query.Condition notEnum_ImportStage()
  {
    com.runwaysdk.query.QueryFactory queryFactory = this.getQueryFactory();
    com.runwaysdk.business.RelationshipQuery relationshipQuery = queryFactory.relationshipQuery(com.runwaysdk.system.metadata.EnumerationAttributeItem.CLASS);

    com.runwaysdk.business.BusinessQuery businessQuery = queryFactory.businessQuery(com.runwaysdk.system.metadata.MdEnumeration.CLASS);
    com.runwaysdk.dataaccess.MdEnumerationDAOIF mdEnumerationIF = com.runwaysdk.dataaccess.metadata.MdEnumerationDAO.getMdEnumerationDAO(net.geoprism.registry.etl.ImportStage.CLASS); 
    businessQuery.WHERE(businessQuery.oid().EQ(mdEnumerationIF.getOid()));

    relationshipQuery.WHERE(relationshipQuery.hasParent(businessQuery));

    return this.getBusinessQuery().isNotChildIn(relationshipQuery);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ImportStageMasterQueryReferenceIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryReferenceIF
  {


    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.etl.ImportStageMaster importStageMaster);

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.etl.ImportStageMaster importStageMaster);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ImportStageMasterQueryReference extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryReference
 implements ImportStageMasterQueryReferenceIF

  {

  public ImportStageMasterQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.etl.ImportStageMaster importStageMaster)
    {
      if(importStageMaster == null) return this.EQ((java.lang.String)null);
      return this.EQ(importStageMaster.getOid());
    }

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.etl.ImportStageMaster importStageMaster)
    {
      if(importStageMaster == null) return this.NE((java.lang.String)null);
      return this.NE(importStageMaster.getOid());
    }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public interface ImportStageMasterQueryEnumerationIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryEnumerationIF
  {


  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public static class ImportStageMasterQueryEnumeration extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryEnumeration
 implements ImportStageMasterQueryEnumerationIF
  {

  public ImportStageMasterQueryEnumeration(com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdEnumerationTableName,com.runwaysdk.dataaccess.MdBusinessDAOIF masterMdBusinessIF, String masterTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterMdBusinessIF, masterTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

  }

/**
 * Specifies type safe query methods for the enumeration net.geoprism.registry.etl.ImportStage.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public interface ImportStageQueryIF extends ImportStageMasterQueryEnumerationIF  {

    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportStage ... importStage);
    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportStage ... importStage);
    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportStage ... importStage);
    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportStage ... importStage);
    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportStage ... importStage);
  }

/**
 * Implements type safe query methods for the enumeration net.geoprism.registry.etl.ImportStage.
 * This type is used when a join is performed on this class as an enumeration.
 **/
  public static class ImportStageQuery extends ImportStageMasterQueryEnumeration implements  ImportStageQueryIF
  {
  public ImportStageQuery(com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdEnumerationTableName,com.runwaysdk.dataaccess.MdBusinessDAOIF masterMdBusinessIF, String masterTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterMdBusinessIF, masterTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }

    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportStage ... importStage)  {

      String[] enumIdArray = new String[importStage.length]; 

      for (int i=0; i<importStage.length; i++)
      {
        enumIdArray[i] = importStage[i].getOid();
      }

      return this.containsAny(enumIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportStage ... importStage)  {

      String[] enumIdArray = new String[importStage.length]; 

      for (int i=0; i<importStage.length; i++)
      {
        enumIdArray[i] = importStage[i].getOid();
      }

      return this.notContainsAny(enumIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportStage ... importStage)  {

      String[] enumIdArray = new String[importStage.length]; 

      for (int i=0; i<importStage.length; i++)
      {
        enumIdArray[i] = importStage[i].getOid();
      }

      return this.containsAll(enumIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportStage ... importStage)  {

      String[] enumIdArray = new String[importStage.length]; 

      for (int i=0; i<importStage.length; i++)
      {
        enumIdArray[i] = importStage[i].getOid();
      }

      return this.notContainsAll(enumIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportStage ... importStage)  {

      String[] enumIdArray = new String[importStage.length]; 

      for (int i=0; i<importStage.length; i++)
      {
        enumIdArray[i] = importStage[i].getOid();
      }

      return this.containsExactly(enumIdArray);
  }
  }
/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ImportStageMasterQueryMultiReferenceIF extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryMultiReferenceIF
  {


    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster);
    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster);
    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster);
    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster);
    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ImportStageMasterQueryMultiReference extends com.runwaysdk.system.EnumerationMasterQuery.EnumerationMasterQueryMultiReference
 implements ImportStageMasterQueryMultiReferenceIF

  {

  public ImportStageMasterQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster)  {

      String[] itemIdArray = new String[importStageMaster.length]; 

      for (int i=0; i<importStageMaster.length; i++)
      {
        itemIdArray[i] = importStageMaster[i].getOid();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster)  {

      String[] itemIdArray = new String[importStageMaster.length]; 

      for (int i=0; i<importStageMaster.length; i++)
      {
        itemIdArray[i] = importStageMaster[i].getOid();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster)  {

      String[] itemIdArray = new String[importStageMaster.length]; 

      for (int i=0; i<importStageMaster.length; i++)
      {
        itemIdArray[i] = importStageMaster[i].getOid();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster)  {

      String[] itemIdArray = new String[importStageMaster.length]; 

      for (int i=0; i<importStageMaster.length; i++)
      {
        itemIdArray[i] = importStageMaster[i].getOid();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportStageMaster ... importStageMaster)  {

      String[] itemIdArray = new String[importStageMaster.length]; 

      for (int i=0; i<importStageMaster.length; i++)
      {
        itemIdArray[i] = importStageMaster[i].getOid();
      }

      return this.containsExactly(itemIdArray);
  }
  }
}
