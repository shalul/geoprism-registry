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
package net.geoprism.registry.model.postgres;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.commongeoregistry.adapter.Term;
import org.commongeoregistry.adapter.constants.DefaultAttribute;
import org.commongeoregistry.adapter.constants.DefaultTerms;
import org.commongeoregistry.adapter.dataaccess.Attribute;
import org.commongeoregistry.adapter.dataaccess.GeoObject;
import org.commongeoregistry.adapter.dataaccess.LocalizedValue;
import org.commongeoregistry.adapter.dataaccess.UnknownTermException;
import org.commongeoregistry.adapter.metadata.AttributeBooleanType;
import org.commongeoregistry.adapter.metadata.AttributeDateType;
import org.commongeoregistry.adapter.metadata.AttributeFloatType;
import org.commongeoregistry.adapter.metadata.AttributeIntegerType;
import org.commongeoregistry.adapter.metadata.AttributeTermType;
import org.commongeoregistry.adapter.metadata.AttributeType;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runwaysdk.business.Business;
import com.runwaysdk.business.BusinessEnumeration;
import com.runwaysdk.business.BusinessQuery;
import com.runwaysdk.business.LocalStruct;
import com.runwaysdk.dataaccess.MdAttributeConcreteDAOIF;
import com.runwaysdk.dataaccess.MdBusinessDAOIF;
import com.runwaysdk.dataaccess.ProgrammingErrorException;
import com.runwaysdk.dataaccess.database.Database;
import com.runwaysdk.dataaccess.metadata.MdBusinessDAO;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.system.gis.geo.GeoEntity;
import com.runwaysdk.system.gis.geo.Universal;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;

import net.geoprism.dashboard.GeometryUpdateException;
import net.geoprism.ontology.Classifier;
import net.geoprism.registry.GeoObjectStatus;
import net.geoprism.registry.GeometryTypeException;
import net.geoprism.registry.RegistryConstants;
import net.geoprism.registry.conversion.LocalizedValueConverter;
import net.geoprism.registry.io.TermValueException;
import net.geoprism.registry.model.ServerChildTreeNode;
import net.geoprism.registry.model.ServerGeoObjectIF;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.ServerHierarchyType;
import net.geoprism.registry.model.ServerParentTreeNode;
import net.geoprism.registry.service.RegistryIdService;
import net.geoprism.registry.service.ServiceFactory;

public class LeafServerGeoObject extends RelationalServerGeoObject implements ServerGeoObjectIF
{
  private Logger logger = LoggerFactory.getLogger(LeafServerGeoObject.class);

  public LeafServerGeoObject(ServerGeoObjectType type, Business business)
  {
    super(type, business);
  }

  @Override
  public String getCode()
  {
    return this.getBusiness().getValue(DefaultAttribute.CODE.getName());
  }

  @Override
  public void setCode(String code)
  {
    this.getBusiness().setValue(GeoObject.CODE, code);
  }

  @Override
  public void setGeometry(Geometry geometry)
  {
    if (geometry != null)
    {
      if (!this.isValidGeometry(geometry))
      {
        GeometryTypeException ex = new GeometryTypeException();
        ex.setActualType(geometry.getGeometryType());
        ex.setExpectedType(this.getType().getGeometryType().name());

        throw ex;
      }
      else
      {
        this.getBusiness().setValue(RegistryConstants.GEOMETRY_ATTRIBUTE_NAME, geometry);
      }
    }
  }

  @Override
  public Geometry getGeometry()
  {
    return (Geometry) this.getBusiness().getObjectValue(RegistryConstants.GEOMETRY_ATTRIBUTE_NAME);
  }

  public void setDisplayLabel(LocalizedValue label)
  {
    LocalizedValueConverter.populate((LocalStruct) this.getBusiness().getStruct(GeoObject.DISPLAY_LABEL), label);
  }

  @Override
  public LocalizedValue getDisplayLabel()
  {
    return LocalizedValueConverter.convert((LocalStruct) this.getBusiness().getStruct(DefaultAttribute.DISPLAY_LABEL.getName()));
  }

  @Override
  public String getRunwayId()
  {
    return this.getBusiness().getOid();
  }

  @Override
  public List<? extends MdAttributeConcreteDAOIF> getMdAttributeDAOs()
  {
    return this.getBusiness().getMdAttributeDAOs();
  }

  @Override
  public ServerChildTreeNode getChildGeoObjects(String[] childrenTypes, Boolean recursive)
  {
    throw new UnsupportedOperationException("Leaf nodes cannot have children.");
  }

  @Override
  public ServerParentTreeNode getParentGeoObjects(String[] parentTypes, Boolean recursive)
  {
    return RelationalServerGeoObject.internalGetParentGeoObjects(this, parentTypes, recursive, null);
  }

  @Override
  public void removeChild(ServerGeoObjectIF child, String hierarchyCode)
  {
    throw new UnsupportedOperationException("Virtual leaf nodes cannot have children.");
  }

  @Override
  public ServerParentTreeNode addChild(ServerGeoObjectIF child, ServerHierarchyType hierarchy)
  {
    throw new UnsupportedOperationException("Virtual leaf nodes cannot have children.");
  }

  @Override
  public ServerParentTreeNode addChild(ServerGeoObjectIF child, ServerHierarchyType hierarchy, Date startDate, Date endDate)
  {
    return this.addChild(child, hierarchy);
  }

  @Override
  public void removeParent(ServerGeoObjectIF parent, ServerHierarchyType hierarchyType)
  {
    String refAttrName = hierarchyType.getParentReferenceAttributeName(parent.getType().getUniversal());

    this.getBusiness().appLock();
    this.getBusiness().setValue(refAttrName, null);
    this.getBusiness().apply();
  }

  @Override
  public ServerParentTreeNode addParent(ServerGeoObjectIF parent, ServerHierarchyType hierarchyType)
  {
    Universal parentUniversal = parent.getType().getUniversal();
    Universal childUniversal = this.getType().getUniversal();

    String refAttrName = hierarchyType.getParentReferenceAttributeName(parentUniversal);
    String universalRelationshipType = hierarchyType.getUniversalRelationship().definesType();

    GeoEntity.validateUniversalRelationship(childUniversal, parentUniversal, universalRelationshipType);

    this.getBusiness().appLock();
    this.getBusiness().setValue(refAttrName, ( (TreeServerGeoObject) parent ).getGeoEntity().getOid());
    this.getBusiness().apply();

    ServerParentTreeNode node = new ServerParentTreeNode(this, hierarchyType, null);
    node.addParent(new ServerParentTreeNode(parent, hierarchyType, null));

    return node;
  }

  @Override
  public ServerParentTreeNode addParent(ServerGeoObjectIF parent, ServerHierarchyType hierarchyType, Date startDate, Date endDate)
  {
    return this.addParent(parent, hierarchyType);
  }

  @Override
  public void lock()
  {
    if (!this.getBusiness().isNew())
    {
      this.getBusiness().appLock();
    }
  }

  @Override
  public void unlock()
  {
    if (!this.getBusiness().isNew())
    {
      this.getBusiness().unlock();
    }
  }

  public void apply(boolean isImport)
  {
    if (!isImport && !this.getBusiness().isNew() && !this.getType().isGeometryEditable() && this.getBusiness().isModified(RegistryConstants.GEOMETRY_ATTRIBUTE_NAME))
    {
      throw new GeometryUpdateException();
    }

    this.getBusiness().apply();
  }

  @Override
  public String bbox(Date date)
  {
    String definesType = this.getType().definesType();

    try
    {
      MdBusinessDAOIF mdBusiness = MdBusinessDAO.getMdBusinessDAO(definesType);
      MdAttributeConcreteDAOIF mdAttribute = mdBusiness.definesAttribute(RegistryConstants.GEOMETRY_ATTRIBUTE_NAME);

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ST_AsText(ST_Extent(" + mdAttribute.getColumnName() + ")) AS bbox");
      sql.append(" FROM " + mdBusiness.getTableName());
      sql.append(" WHERE " + GeoEntity.OID + " = '" + this.getBusiness().getOid() + "'");

      try (ResultSet resultSet = Database.query(sql.toString()))
      {
        if (resultSet.next())
        {
          String bbox = resultSet.getString("bbox");

          if (bbox != null)
          {
            if (bbox.contains("POLYGON"))
            {
              Pattern p = Pattern.compile("POLYGON\\(\\((.*)\\)\\)");
              Matcher m = p.matcher(bbox);

              if (m.matches())
              {
                String coordinates = m.group(1);
                List<Coordinate> coords = new LinkedList<Coordinate>();

                for (String c : coordinates.split(","))
                {
                  String[] xAndY = c.split(" ");
                  double x = Double.valueOf(xAndY[0]);
                  double y = Double.valueOf(xAndY[1]);

                  coords.add(new Coordinate(x, y));
                }

                Envelope e = new Envelope(coords.get(0), coords.get(2));

                JSONArray bboxArr = new JSONArray();
                bboxArr.put(e.getMinX());
                bboxArr.put(e.getMinY());
                bboxArr.put(e.getMaxX());
                bboxArr.put(e.getMaxY());

                return bboxArr.toString();
              }
              else
              {
                throw new ProgrammingErrorException("Pattern did not match on bbox " + bbox);
              }
            }
            else if (bbox.contains("POINT"))
            {
              Pattern p = Pattern.compile("POINT\\((.*)\\)");
              Matcher m = p.matcher(bbox);

              if (m.matches())
              {
                String sCoordinate = m.group(1);

                String[] xAndY = sCoordinate.split(" ");
                double x = Double.valueOf(xAndY[0]);
                double y = Double.valueOf(xAndY[1]);
                Coordinate coordinate = new Coordinate(x, y);

                Envelope e = new Envelope(coordinate, coordinate);

                JSONArray bboxArr = new JSONArray();
                bboxArr.put(e.getMinX());
                bboxArr.put(e.getMinY());
                bboxArr.put(e.getMaxX());
                bboxArr.put(e.getMaxY());

                return bboxArr.toString();
              }
              else
              {
                throw new ProgrammingErrorException("Pattern did not match on bbox " + bbox);
              }
            }
            else
            {
              throw new UnsupportedOperationException("Unsupported bbox geometry type for bbox [" + bbox + "].");
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      logger.error("Unable to compute bounding box for leaf type [" + definesType + "].", e);
    }

    // Extent of the continental United States
    JSONArray bboxArr = new JSONArray();
    bboxArr.put(-125.0011);
    bboxArr.put(24.9493);
    bboxArr.put(-66.9326);
    bboxArr.put(49.5904);

    return bboxArr.toString();

  }

  @Override
  public GeoObject toGeoObject()
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ServerGeoObjectType type = this.getType();

    Map<String, Attribute> attributeMap = GeoObject.buildAttributeMap(type.getType());

    GeoObject geoObj = new GeoObject(type.getType(), type.getGeometryType(), attributeMap);

    if (this.getBusiness().isNew() && !this.getBusiness().isAppliedToDB())
    {
      geoObj.setUid(RegistryIdService.getInstance().next());

      geoObj.setStatus(ServiceFactory.getAdapter().getMetadataCache().getTerm(DefaultTerms.GeoObjectStatusTerm.NEW.code).get());
    }
    else
    {
      geoObj.setUid(this.getBusiness().getValue(RegistryConstants.UUID));

      Map<String, AttributeType> attributes = type.getAttributeMap();
      attributes.forEach((attributeName, attribute) -> {
        if (attributeName.equals(DefaultAttribute.STATUS.getName()))
        {
          BusinessEnumeration busEnum = this.getBusiness().getEnumValues(attributeName).get(0);
          GeoObjectStatus gos = GeoObjectStatus.valueOf(busEnum.name());
          Term statusTerm = ServiceFactory.getConversionService().geoObjectStatusToTerm(gos);

          geoObj.setStatus(statusTerm);
        }
        else if (attributeName.equals(DefaultAttribute.TYPE.getName()))
        {
          // Ignore
        }
        else if (this.getBusiness().hasAttribute(attributeName))
        {
          String value = this.getBusiness().getValue(attributeName);

          if (value != null && value.length() > 0)
          {
            if (attribute instanceof AttributeTermType)
            {
              Classifier classifier = Classifier.get(value);

              try
              {
                geoObj.setValue(attributeName, classifier.getClassifierId());
              }
              catch (UnknownTermException e)
              {
                TermValueException ex = new TermValueException();
                ex.setAttributeLabel(e.getAttribute().getLabel().getValue());
                ex.setCode(e.getCode());

                throw e;
              }

            }
            else if (attribute instanceof AttributeDateType)
            {
              try
              {
                geoObj.setValue(attributeName, format.parse(value));
              }
              catch (ParseException e)
              {
                throw new RuntimeException(e);
              }
            }
            else if (attribute instanceof AttributeBooleanType)
            {
              geoObj.setValue(attributeName, new Boolean(value));
            }
            else if (attribute instanceof AttributeFloatType)
            {
              geoObj.setValue(attributeName, new Double(value));
            }
            else if (attribute instanceof AttributeIntegerType)
            {
              geoObj.setValue(attributeName, new Long(value));
            }
            else
            {
              geoObj.setValue(attributeName, value);
            }
          }
        }
      });
    }

    geoObj.setCode(this.getBusiness().getValue(DefaultAttribute.CODE.getName()));
    geoObj.setDisplayLabel(this.getDisplayLabel());
    geoObj.setGeometry((Geometry) this.getBusiness().getObjectValue(RegistryConstants.GEOMETRY_ATTRIBUTE_NAME));

    return geoObj;
  }

  public static Business getByCode(ServerGeoObjectType type, String code)
  {
    BusinessQuery query = new QueryFactory().businessQuery(type.definesType());
    query.WHERE(query.aCharacter(DefaultAttribute.CODE.getName()).EQ(code));

    try (OIterator<Business> iterator = query.getIterator())
    {
      if (iterator.hasNext())
      {
        return iterator.next();
      }
    }

    return null;
  }
}
