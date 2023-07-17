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

@com.runwaysdk.business.ClassSignature(hash = -1829172152)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ImportHistory.java
 *
 * @author Autogenerated by RunwaySDK
 */
public  class ImportHistoryQuery extends com.runwaysdk.system.scheduler.JobHistoryQuery

{

  public ImportHistoryQuery(com.runwaysdk.query.QueryFactory componentQueryFactory)
  {
    super(componentQueryFactory);
    if (this.getComponentQuery() == null)
    {
      com.runwaysdk.business.BusinessQuery businessQuery = componentQueryFactory.businessQuery(this.getClassType());

       this.setBusinessQuery(businessQuery);
    }
  }

  public ImportHistoryQuery(com.runwaysdk.query.ValueQuery valueQuery)
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
    return net.geoprism.registry.etl.ImportHistory.CLASS;
  }
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson()
  {
    return getCompletedRowsJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getConfigJson()
  {
    return getConfigJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorCount()
  {
    return getErrorCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount()
  {
    return getErrorResolvedCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode()
  {
    return getGeoObjectTypeCode(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, displayLabel);

  }
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile()
  {
    return getImportFile(null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.IMPORTFILE);

    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.IMPORTFILE, mdAttributeIF, this, alias, null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.IMPORTFILE);

    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.IMPORTFILE, mdAttributeIF, this, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getImportedRecords()
  {
    return getImportedRecords(null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.getComponentQuery().get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, displayLabel);

  }
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization()
  {
    return getOrganization(null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.ORGANIZATION);

    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.ORGANIZATION, mdAttributeIF, this, alias, null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.ORGANIZATION);

    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.ORGANIZATION, mdAttributeIF, this, alias, displayLabel);

  }
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage()
  {
    return getStage(null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.STAGE);

    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.STAGE, mdAttributeIF, this, alias, null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias, String displayLabel)
  {

    com.runwaysdk.dataaccess.MdAttributeDAOIF mdAttributeIF = this.getComponentQuery().getMdAttributeROfromMap(net.geoprism.registry.etl.ImportHistory.STAGE);

    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.getComponentQuery().internalAttributeFactory(net.geoprism.registry.etl.ImportHistory.STAGE, mdAttributeIF, this, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.IMPORTFILE)) 
    {
       return new com.runwaysdk.system.VaultFileQuery.VaultFileQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(net.geoprism.registry.etl.ImportHistory.ORGANIZATION)) 
    {
       return new net.geoprism.registry.OrganizationQuery.OrganizationQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.STAGE)) 
    {
       return new net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  /**  
   * Returns an iterator of Business objects that match the query criteria specified
   * on this query object. 
   * @return iterator of Business objects that match the query criteria specified
   * on this query object.
   */
  public com.runwaysdk.query.OIterator<? extends ImportHistory> getIterator()
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
    return new com.runwaysdk.business.BusinessIterator<ImportHistory>(this.getComponentQuery().getMdEntityIF(), columnInfoMap, results);
  }


/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ImportHistoryQueryReferenceIF extends com.runwaysdk.system.scheduler.JobHistoryQuery.JobHistoryQueryReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getCompletedRowsJson();
    public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias);
    public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getConfigJson();
    public com.runwaysdk.query.SelectableChar getConfigJson(String alias);
    public com.runwaysdk.query.SelectableChar getConfigJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getErrorCount();
    public com.runwaysdk.query.SelectableLong getErrorCount(String alias);
    public com.runwaysdk.query.SelectableLong getErrorCount(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount();
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias);
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode();
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias);
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias, String displayLabel);
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile();
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias);
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getImportedRecords();
    public com.runwaysdk.query.SelectableLong getImportedRecords(String alias);
    public com.runwaysdk.query.SelectableLong getImportedRecords(String alias, String displayLabel);
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization();
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias);
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias, String displayLabel);
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage();
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias);
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias, String displayLabel);

    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.etl.ImportHistory importHistory);

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.etl.ImportHistory importHistory);

  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ImportHistoryQueryReference extends com.runwaysdk.system.scheduler.JobHistoryQuery.JobHistoryQueryReference
 implements ImportHistoryQueryReferenceIF

  {

  public ImportHistoryQueryReference(com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }


    public com.runwaysdk.query.BasicCondition EQ(net.geoprism.registry.etl.ImportHistory importHistory)
    {
      if(importHistory == null) return this.EQ((java.lang.String)null);
      return this.EQ(importHistory.getOid());
    }

    public com.runwaysdk.query.BasicCondition NE(net.geoprism.registry.etl.ImportHistory importHistory)
    {
      if(importHistory == null) return this.NE((java.lang.String)null);
      return this.NE(importHistory.getOid());
    }

  public com.runwaysdk.query.SelectableChar getCompletedRowsJson()
  {
    return getCompletedRowsJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getConfigJson()
  {
    return getConfigJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorCount()
  {
    return getErrorCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount()
  {
    return getErrorResolvedCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode()
  {
    return getGeoObjectTypeCode(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, displayLabel);

  }
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile()
  {
    return getImportFile(null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias)
  {
    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTFILE, alias, null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTFILE,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getImportedRecords()
  {
    return getImportedRecords(null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, displayLabel);

  }
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization()
  {
    return getOrganization(null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias)
  {
    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.ORGANIZATION, alias, null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias, String displayLabel)
  {
    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.ORGANIZATION,  alias, displayLabel);

  }
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage()
  {
    return getStage(null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias)
  {
    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.get(net.geoprism.registry.etl.ImportHistory.STAGE, alias, null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias, String displayLabel)
  {
    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.get(net.geoprism.registry.etl.ImportHistory.STAGE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.IMPORTFILE)) 
    {
       return new com.runwaysdk.system.VaultFileQuery.VaultFileQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(net.geoprism.registry.etl.ImportHistory.ORGANIZATION)) 
    {
       return new net.geoprism.registry.OrganizationQuery.OrganizationQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.STAGE)) 
    {
       return new net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }

/**
 * Interface that masks all type unsafe query methods and defines all type safe methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public interface ImportHistoryQueryMultiReferenceIF extends com.runwaysdk.system.scheduler.JobHistoryQuery.JobHistoryQueryMultiReferenceIF
  {

    public com.runwaysdk.query.SelectableChar getCompletedRowsJson();
    public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias);
    public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getConfigJson();
    public com.runwaysdk.query.SelectableChar getConfigJson(String alias);
    public com.runwaysdk.query.SelectableChar getConfigJson(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getErrorCount();
    public com.runwaysdk.query.SelectableLong getErrorCount(String alias);
    public com.runwaysdk.query.SelectableLong getErrorCount(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount();
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias);
    public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode();
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias);
    public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias, String displayLabel);
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile();
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias);
    public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias, String displayLabel);
    public com.runwaysdk.query.SelectableLong getImportedRecords();
    public com.runwaysdk.query.SelectableLong getImportedRecords(String alias);
    public com.runwaysdk.query.SelectableLong getImportedRecords(String alias, String displayLabel);
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization();
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias);
    public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias, String displayLabel);
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage();
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias);
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias, String displayLabel);

    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportHistory ... importHistory);
    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportHistory ... importHistory);
    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportHistory ... importHistory);
    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportHistory ... importHistory);
    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportHistory ... importHistory);
  }

/**
 * Implements type safe query methods.
 * This type is used when a join is performed on this class as a reference.
 **/
  public static class ImportHistoryQueryMultiReference extends com.runwaysdk.system.scheduler.JobHistoryQuery.JobHistoryQueryMultiReference
 implements ImportHistoryQueryMultiReferenceIF

  {

  public ImportHistoryQueryMultiReference(com.runwaysdk.dataaccess.MdAttributeMultiReferenceDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias, String mdMultiReferenceTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String alias, String displayLabel)
  {
    super(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdMultiReferenceTableName, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, alias, displayLabel);

  }



    public com.runwaysdk.query.Condition containsAny(net.geoprism.registry.etl.ImportHistory ... importHistory)  {

      String[] itemIdArray = new String[importHistory.length]; 

      for (int i=0; i<importHistory.length; i++)
      {
        itemIdArray[i] = importHistory[i].getOid();
      }

      return this.containsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAny(net.geoprism.registry.etl.ImportHistory ... importHistory)  {

      String[] itemIdArray = new String[importHistory.length]; 

      for (int i=0; i<importHistory.length; i++)
      {
        itemIdArray[i] = importHistory[i].getOid();
      }

      return this.notContainsAny(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsAll(net.geoprism.registry.etl.ImportHistory ... importHistory)  {

      String[] itemIdArray = new String[importHistory.length]; 

      for (int i=0; i<importHistory.length; i++)
      {
        itemIdArray[i] = importHistory[i].getOid();
      }

      return this.containsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition notContainsAll(net.geoprism.registry.etl.ImportHistory ... importHistory)  {

      String[] itemIdArray = new String[importHistory.length]; 

      for (int i=0; i<importHistory.length; i++)
      {
        itemIdArray[i] = importHistory[i].getOid();
      }

      return this.notContainsAll(itemIdArray);
  }

    public com.runwaysdk.query.Condition containsExactly(net.geoprism.registry.etl.ImportHistory ... importHistory)  {

      String[] itemIdArray = new String[importHistory.length]; 

      for (int i=0; i<importHistory.length; i++)
      {
        itemIdArray[i] = importHistory[i].getOid();
      }

      return this.containsExactly(itemIdArray);
  }
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson()
  {
    return getCompletedRowsJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getCompletedRowsJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.COMPLETEDROWSJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getConfigJson()
  {
    return getConfigJson(null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getConfigJson(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.CONFIGJSON, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorCount()
  {
    return getErrorCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount()
  {
    return getErrorResolvedCount(null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getErrorResolvedCount(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.ERRORRESOLVEDCOUNT, alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode()
  {
    return getGeoObjectTypeCode(null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, null);

  }
 
  public com.runwaysdk.query.SelectableChar getGeoObjectTypeCode(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableChar)this.get(net.geoprism.registry.etl.ImportHistory.GEOOBJECTTYPECODE, alias, displayLabel);

  }
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile()
  {
    return getImportFile(null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias)
  {
    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTFILE, alias, null);

  }
 
  public com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF getImportFile(String alias, String displayLabel)
  {
    return (com.runwaysdk.system.VaultFileQuery.VaultFileQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTFILE,  alias, displayLabel);

  }
  public com.runwaysdk.query.SelectableLong getImportedRecords()
  {
    return getImportedRecords(null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, null);

  }
 
  public com.runwaysdk.query.SelectableLong getImportedRecords(String alias, String displayLabel)
  {
    return (com.runwaysdk.query.SelectableLong)this.get(net.geoprism.registry.etl.ImportHistory.IMPORTEDRECORDS, alias, displayLabel);

  }
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization()
  {
    return getOrganization(null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias)
  {
    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.ORGANIZATION, alias, null);

  }
 
  public net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF getOrganization(String alias, String displayLabel)
  {
    return (net.geoprism.registry.OrganizationQuery.OrganizationQueryReferenceIF)this.get(net.geoprism.registry.etl.ImportHistory.ORGANIZATION,  alias, displayLabel);

  }
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage()
  {
    return getStage(null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias)
  {
    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.get(net.geoprism.registry.etl.ImportHistory.STAGE, alias, null);

  }
 
  public net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF getStage(String alias, String displayLabel)
  {
    return (net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQueryIF)this.get(net.geoprism.registry.etl.ImportHistory.STAGE, alias, displayLabel);

  }
  protected com.runwaysdk.query.AttributeReference referenceFactory( com.runwaysdk.dataaccess.MdAttributeRefDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  com.runwaysdk.dataaccess.MdBusinessDAOIF referenceMdBusinessIF, String referenceTableAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.IMPORTFILE)) 
    {
       return new com.runwaysdk.system.VaultFileQuery.VaultFileQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else if (name.equals(net.geoprism.registry.etl.ImportHistory.ORGANIZATION)) 
    {
       return new net.geoprism.registry.OrganizationQuery.OrganizationQueryReference((com.runwaysdk.dataaccess.MdAttributeRefDAOIF)mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.referenceFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, referenceMdBusinessIF, referenceTableAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  protected com.runwaysdk.query.AttributeEnumeration enumerationFactory( com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF mdAttributeIF, String attributeNamespace, String definingTableName, String definingTableAlias,  String mdEnumerationTableName, com.runwaysdk.dataaccess.MdBusinessDAOIF masterListMdBusinessIF, String masterListTalbeAlias, com.runwaysdk.query.ComponentQuery rootQuery, java.util.Set<com.runwaysdk.query.Join> tableJoinSet, String userDefinedAlias, String userDefinedDisplayLabel)
  {
    String name = mdAttributeIF.definesAttribute();
    
    if (name.equals(net.geoprism.registry.etl.ImportHistory.STAGE)) 
    {
       return new net.geoprism.registry.etl.ImportStageMasterQuery.ImportStageQuery((com.runwaysdk.dataaccess.MdAttributeEnumerationDAOIF)mdAttributeIF,  attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
    else 
    {
      return super.enumerationFactory(mdAttributeIF, attributeNamespace, definingTableName, definingTableAlias, mdEnumerationTableName, masterListMdBusinessIF, masterListTalbeAlias, rootQuery, tableJoinSet, userDefinedAlias, userDefinedDisplayLabel);
    }
  }

  }
}
