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
package net.geoprism.graph;

@com.runwaysdk.business.ClassSignature(hash = 153744388)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to PublishLabeledPropertyGraphTypeVersionJob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class PublishLabeledPropertyGraphTypeVersionJobBase extends com.runwaysdk.system.scheduler.ExecutableJob
{
  public final static String CLASS = "net.geoprism.graph.PublishLabeledPropertyGraphTypeVersionJob";
  public final static java.lang.String GRAPHTYPE = "graphType";
  public final static java.lang.String VERSION = "version";
  @SuppressWarnings("unused")
  private static final long serialVersionUID = 153744388;
  
  public PublishLabeledPropertyGraphTypeVersionJobBase()
  {
    super();
  }
  
  public net.geoprism.graph.LabeledPropertyGraphType getGraphType()
  {
    if (getValue(GRAPHTYPE).trim().equals(""))
    {
      return null;
    }
    else
    {
      return net.geoprism.graph.LabeledPropertyGraphType.get(getValue(GRAPHTYPE));
    }
  }
  
  public String getGraphTypeOid()
  {
    return getValue(GRAPHTYPE);
  }
  
  public void validateGraphType()
  {
    this.validateAttribute(GRAPHTYPE);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getGraphTypeMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.graph.PublishLabeledPropertyGraphTypeVersionJob.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(GRAPHTYPE);
  }
  
  public void setGraphType(net.geoprism.graph.LabeledPropertyGraphType value)
  {
    if(value == null)
    {
      setValue(GRAPHTYPE, "");
    }
    else
    {
      setValue(GRAPHTYPE, value.getOid());
    }
  }
  
  public void setGraphTypeId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(GRAPHTYPE, "");
    }
    else
    {
      setValue(GRAPHTYPE, oid);
    }
  }
  
  public net.geoprism.graph.LabeledPropertyGraphTypeVersion getVersion()
  {
    if (getValue(VERSION).trim().equals(""))
    {
      return null;
    }
    else
    {
      return net.geoprism.graph.LabeledPropertyGraphTypeVersion.get(getValue(VERSION));
    }
  }
  
  public String getVersionOid()
  {
    return getValue(VERSION);
  }
  
  public void validateVersion()
  {
    this.validateAttribute(VERSION);
  }
  
  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getVersionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.graph.PublishLabeledPropertyGraphTypeVersionJob.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF)mdClassIF.definesAttribute(VERSION);
  }
  
  public void setVersion(net.geoprism.graph.LabeledPropertyGraphTypeVersion value)
  {
    if(value == null)
    {
      setValue(VERSION, "");
    }
    else
    {
      setValue(VERSION, value.getOid());
    }
  }
  
  public void setVersionId(java.lang.String oid)
  {
    if(oid == null)
    {
      setValue(VERSION, "");
    }
    else
    {
      setValue(VERSION, oid);
    }
  }
  
  protected String getDeclaredType()
  {
    return CLASS;
  }
  
  public static PublishLabeledPropertyGraphTypeVersionJobQuery getAllInstances(String sortAttribute, Boolean ascending, Integer pageSize, Integer pageNumber)
  {
    PublishLabeledPropertyGraphTypeVersionJobQuery query = new PublishLabeledPropertyGraphTypeVersionJobQuery(new com.runwaysdk.query.QueryFactory());
    com.runwaysdk.business.Entity.getAllInstances(query, sortAttribute, ascending, pageSize, pageNumber);
    return query;
  }
  
  public static PublishLabeledPropertyGraphTypeVersionJob get(String oid)
  {
    return (PublishLabeledPropertyGraphTypeVersionJob) com.runwaysdk.business.Business.get(oid);
  }
  
  public static PublishLabeledPropertyGraphTypeVersionJob getByKey(String key)
  {
    return (PublishLabeledPropertyGraphTypeVersionJob) com.runwaysdk.business.Business.get(CLASS, key);
  }
  
  public static PublishLabeledPropertyGraphTypeVersionJob lock(java.lang.String oid)
  {
    PublishLabeledPropertyGraphTypeVersionJob _instance = PublishLabeledPropertyGraphTypeVersionJob.get(oid);
    _instance.lock();
    
    return _instance;
  }
  
  public static PublishLabeledPropertyGraphTypeVersionJob unlock(java.lang.String oid)
  {
    PublishLabeledPropertyGraphTypeVersionJob _instance = PublishLabeledPropertyGraphTypeVersionJob.get(oid);
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
