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
package net.geoprism.registry.graph;

@com.runwaysdk.business.ClassSignature(hash = -1706731812)
/**
 * This class is generated automatically. DO NOT MAKE CHANGES TO IT - THEY WILL
 * BE OVERWRITTEN Custom business logic should be added to ExternalSystem.java
 *
 * @author Autogenerated by RunwaySDK
 */
public abstract class ExternalSystemBase extends com.runwaysdk.business.graph.VertexObject
{
  public final static String     CLASS            = "net.geoprism.registry.graph.ExternalSystem";

  public static java.lang.String DESCRIPTION      = "description";

  public static java.lang.String ID               = "id";

  public static java.lang.String LABEL            = "label";

  public static java.lang.String OID              = "oid";

  public static java.lang.String ORGANIZATION     = "organization";

  public static java.lang.String SEQ              = "seq";

  private static final long      serialVersionUID = -1706731812;

  public ExternalSystemBase()
  {
    super();
  }

  public com.runwaysdk.ComponentIF getDescription()
  {
    return (com.runwaysdk.ComponentIF) this.getObjectValue(DESCRIPTION);
  }

  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getDescriptionMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDAOIF) mdClassIF.definesAttribute(DESCRIPTION);
  }

  public void setDescription(com.runwaysdk.ComponentIF value)
  {
    this.setValue(DESCRIPTION, value);
  }

  public String getId()
  {
    return (String) this.getObjectValue(ID);
  }

  public static com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF getIdMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeCharacterDAOIF) mdClassIF.definesAttribute(ID);
  }

  public void setId(String value)
  {
    this.setValue(ID, value);
  }

  public com.runwaysdk.ComponentIF getLabel()
  {
    return (com.runwaysdk.ComponentIF) this.getObjectValue(LABEL);
  }

  public static com.runwaysdk.dataaccess.MdAttributeDAOIF getLabelMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeDAOIF) mdClassIF.definesAttribute(LABEL);
  }

  public void setLabel(com.runwaysdk.ComponentIF value)
  {
    this.setValue(LABEL, value);
  }

  public String getOid()
  {
    return (String) this.getObjectValue(OID);
  }

  public static com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF getOidMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeUUIDDAOIF) mdClassIF.definesAttribute(OID);
  }

  public net.geoprism.registry.Organization getOrganization()
  {
    if (this.getObjectValue(ORGANIZATION) == null)
    {
      return null;
    }
    else
    {
      return net.geoprism.registry.Organization.get((String) this.getObjectValue(ORGANIZATION));
    }
  }

  public String getOrganizationOid()
  {
    return (String) this.getObjectValue(ORGANIZATION);
  }

  public static com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF getOrganizationMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeReferenceDAOIF) mdClassIF.definesAttribute(ORGANIZATION);
  }

  public void setOrganization(net.geoprism.registry.Organization value)
  {
    this.setValue(ORGANIZATION, value.getOid());
  }

  public void setOrganizationId(java.lang.String oid)
  {
    this.setValue(ORGANIZATION, oid);
  }

  public Long getSeq()
  {
    return (Long) this.getObjectValue(SEQ);
  }

  public static com.runwaysdk.dataaccess.MdAttributeLongDAOIF getSeqMd()
  {
    com.runwaysdk.dataaccess.MdClassDAOIF mdClassIF = com.runwaysdk.dataaccess.metadata.MdClassDAO.getMdClassDAO(net.geoprism.registry.graph.ExternalSystem.CLASS);
    return (com.runwaysdk.dataaccess.MdAttributeLongDAOIF) mdClassIF.definesAttribute(SEQ);
  }

  public void setSeq(Long value)
  {
    this.setValue(SEQ, value);
  }

  protected String getDeclaredType()
  {
    return CLASS;
  }

  public com.runwaysdk.business.graph.EdgeObject addExternalIDChild(net.geoprism.registry.graph.GeoVertex geoVertex)
  {
    return super.addChild(geoVertex, "net.geoprism.registry.graph.ExternalID");
  }

  public void removeExternalIDChild(net.geoprism.registry.graph.GeoVertex geoVertex)
  {
    super.removeChild(geoVertex, "net.geoprism.registry.graph.ExternalID");
  }

  
  public java.util.List<net.geoprism.registry.graph.GeoVertex> getExternalIDChildGeoVertexs()
  {
    return super.getChildren("net.geoprism.registry.graph.ExternalID", net.geoprism.registry.graph.GeoVertex.class);
  }

  public static ExternalSystem get(String oid)
  {
    return (ExternalSystem) com.runwaysdk.business.graph.VertexObject.get(CLASS, oid);
  }

  public String toString()
  {
    if (this.isNew())
    {
      return "New: " + this.getClassDisplayLabel();
    }
    else
    {
      return super.toString();
    }
  }
}
