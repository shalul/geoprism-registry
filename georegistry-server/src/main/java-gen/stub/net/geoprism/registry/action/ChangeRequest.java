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
package net.geoprism.registry.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.commongeoregistry.adapter.dataaccess.GeoObjectOverTime;
import org.commongeoregistry.adapter.dataaccess.GeoObjectOverTimeJsonAdapters;
import org.commongeoregistry.adapter.metadata.RegistryRole;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.runwaysdk.business.Business;
import com.runwaysdk.business.BusinessQuery;
import com.runwaysdk.business.RelationshipQuery;
import com.runwaysdk.business.rbac.RoleDAO;
import com.runwaysdk.business.rbac.RoleDAOIF;
import com.runwaysdk.business.rbac.SingleActorDAOIF;
import com.runwaysdk.dataaccess.MdRelationshipDAOIF;
import com.runwaysdk.dataaccess.metadata.MdRelationshipDAO;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.query.OIterator;
import com.runwaysdk.query.OrderBy.SortOrder;
import com.runwaysdk.query.QueryFactory;
import com.runwaysdk.session.Session;
import com.runwaysdk.system.SingleActor;
import com.runwaysdk.system.VaultFile;

import net.geoprism.EmailSetting;
import net.geoprism.GeoprismUser;
import net.geoprism.GeoprismUserQuery;
import net.geoprism.localization.LocalizationFacade;
import net.geoprism.registry.GeoregistryProperties;
import net.geoprism.registry.action.geoobject.CreateGeoObjectAction;
import net.geoprism.registry.action.geoobject.UpdateAttributeAction;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.graph.VertexServerGeoObject;
import net.geoprism.registry.service.ServiceFactory;
import net.geoprism.registry.view.JsonSerializable;

public class ChangeRequest extends ChangeRequestBase implements JsonSerializable
{
  private static final long serialVersionUID = 763209854;

  public ChangeRequest()
  {
    super();
  }

  public List<AbstractAction> getOrderedActions()
  {
    // TODO : Runway querybuilder is dumb
    // QueryFactory qf = new QueryFactory();
    //
    // ChangeRequestQuery crq = new ChangeRequestQuery(qf);
    // AbstractActionQuery aaq = new AbstractActionQuery(qf);
    //
    // aaq.ORDER_BY(aaq.getCreateActionDate(), SortOrder.DESC);
    // aaq.WHERE(aaq.request(crq));
    // aaq.WHERE(crq.getOid().EQ(this.getOid()));
    //
    // return aaq.getIterator().getAll();

    MdRelationshipDAOIF mdRelationshipIF = MdRelationshipDAO.getMdRelationshipDAO(HasActionRelationship.CLASS);

    QueryFactory queryFactory = new QueryFactory();

    // Get the relationships where this object is the parent
    RelationshipQuery rq = queryFactory.relationshipQuery(HasActionRelationship.CLASS);
    rq.WHERE(rq.parentOid().EQ(this.getOid()));

    // Now fetch the child objects
    BusinessQuery bq = queryFactory.businessQuery(mdRelationshipIF.getChildMdBusiness().definesType());
    bq.WHERE(bq.isChildIn(rq));

    bq.ORDER_BY(bq.get(AbstractAction.CREATEACTIONDATE), SortOrder.ASC);

    List<Business> bizes = bq.getIterator().getAll();
    List<AbstractAction> actions = new ArrayList<AbstractAction>();

    for (Business biz : bizes)
    {
      actions.add((AbstractAction) biz);
    }

    return actions;
  }

  @Override
  public void delete()
  {
    List<? extends AbstractAction> actions = this.getOrderedActions();
    for (AbstractAction action : actions)
    {
      action.delete();
    }

    OIterator<? extends ChangeRequestHasDocument> it = this.getAllDocumentRel();
    for (ChangeRequestHasDocument rel : it)
    {
      VaultFile vf = rel.getChild();
      rel.delete();
      vf.delete();
    }

    super.delete();
  }

  public ServerGeoObjectType getGeoObjectType()
  {
    return ServerGeoObjectType.get(this.getGeoObjectTypeCode(), true);
  }

  public VertexServerGeoObject getGeoObject()
  {
    ServerGeoObjectType type = this.getGeoObjectType();

    if (type == null)
    {
      return null;
    }

    return (VertexServerGeoObject) ServiceFactory.getGeoObjectService().getGeoObjectByCode(this.getGeoObjectCode(), type);
  }

  public JsonObject toJSON()
  {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(ChangeRequest.class, new ChangeRequestJsonAdapters.ChangeRequestSerializer());
    builder.registerTypeAdapter(GeoObjectOverTime.class, new GeoObjectOverTimeJsonAdapters.GeoObjectSerializer());

    return (JsonObject) builder.create().toJsonTree(this);
  }
  
  public static ChangeRequest fromJSON(String json)
  {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(ChangeRequest.class, new ChangeRequestJsonAdapters.ChangeRequestDeserializer());
    builder.registerTypeAdapter(GeoObjectOverTime.class, new GeoObjectOverTimeJsonAdapters.GeoObjectDeserializer(ServiceFactory.getAdapter()));

    return builder.create().fromJson(json, ChangeRequest.class);
  }

  public JsonObject getDetails()
  {
    int total = 0;
    int pending = 0;

    OIterator<? extends AbstractAction> it = this.getAllAction();

    try
    {
      while (it.hasNext())
      {
        total++;

        AbstractAction action = it.next();

        if (action.getApprovalStatus().contains(AllGovernanceStatus.PENDING))
        {
          pending++;
        }
      }
    }
    finally
    {
      it.close();
    }
    AllGovernanceStatus status = this.getApprovalStatus().get(0);

    JsonObject object = this.toJSON();
    object.addProperty("total", total);
    object.addProperty("pending", pending);
    object.addProperty("statusCode", status.getEnumName());
    object.addProperty(ChangeRequest.MAINTAINERNOTES, this.getMaintainerNotes());

    return object;
  }
  
  @Override
  public void apply()
  {
    final boolean isNew = this.isNew();
    
    // Cache the Geo-Object label and type label on this object for sorting purposes
    VertexServerGeoObject vsGo = this.getGeoObject();
    ServerGeoObjectType type = vsGo.getType();
    
    this.getGeoObjectLabel().setLocaleMap(vsGo.getDisplayLabel().getLocaleMap());
    this.getGeoObjectTypeLabel().setLocaleMap(type.getLabel().getLocaleMap());
    
    
    super.apply();
    
    // Send an email to RMs telling them about this new CR
    try
    {
      if (isNew)
      {
        SingleActor createdBy = this.getCreatedBy();
  
        if (createdBy instanceof GeoprismUser)
        {
          // Get all RM's for the GOT and Org
          String rmRoleName = RegistryRole.Type.getRM_RoleName(this.getOrganizationCode(), this.getGeoObjectTypeCode());
          RoleDAOIF role = RoleDAO.findRole(rmRoleName);
          Set<SingleActorDAOIF> actors = role.assignedActors();
          
          List<String> toAddresses = new ArrayList<String>();
          for (SingleActorDAOIF actor : actors)
          {
            if (actor.getType().equals(GeoprismUser.CLASS))
            {
              GeoprismUser geoprismUser = GeoprismUser.get(actor.getOid());
              
              String email = geoprismUser.getEmail();
              
              if (email != null && email.length() > 0 && !email.contains("@noreply"))
              {
                toAddresses.add(geoprismUser.getEmail());
              }
            }
          }
          
          if (toAddresses.size() > 0)
          {
            String email = ( (GeoprismUser) createdBy ).getEmail();
    
            if (email != null && email.length() > 0)
            {
              String subject = LocalizationFacade.getFromBundles("change.request.email.submit.subject");
    
              String body = LocalizationFacade.getFromBundles("change.request.email.submit.body");
              body = body.replaceAll("\\\\n", "\n");
              body = body.replaceAll("\\{user\\}", ( (GeoprismUser) createdBy ).getUsername());
              body = body.replaceAll("\\{geoobject\\}", this.getGeoObject().getDisplayLabel().getValue());
              
              String link = GeoregistryProperties.getRemoteServerUrl() + "cgr/manage#/registry/change-requests/" + this.getOid();
              body = body.replaceAll("\\{link\\}", link);
    
               EmailSetting.sendEmail(subject, body, toAddresses.toArray(new String[toAddresses.size()]));
            }
          }
        }
      }
    }
    catch(Throwable t)
    {
      t.printStackTrace();
    }
  }
  
  @Transaction
  public void reject(String maintainerNotes, String additionalNotes)
  {
    this.appLock();
    this.setMaintainerNotes(maintainerNotes);
    this.setAdditionalNotes(additionalNotes);
    this.clearApprovalStatus();
    this.addApprovalStatus(AllGovernanceStatus.REJECTED);
    this.apply();
    
    this.setAllActionsStatus(AllGovernanceStatus.REJECTED);
  }

  @Transaction
  public void execute(String maintainerNotes, String additionalNotes)
  {
    if (this.getApprovalStatus().contains(AllGovernanceStatus.PENDING))
    {
      List<AbstractAction> actions = this.getOrderedActions();

      Set<AllGovernanceStatus> statuses = new TreeSet<AllGovernanceStatus>();

      for (AbstractAction action : actions)
      {
        if (action instanceof UpdateAttributeAction && action.getApprovalStatus().contains(AllGovernanceStatus.PENDING))
        {
          throw new ActionExecuteException("Unable to execute an action with the pending status");
        }
        else if (action instanceof CreateGeoObjectAction && action.getApprovalStatus().contains(AllGovernanceStatus.PENDING))
        {
          action.appLock();
          action.clearApprovalStatus();
          action.addApprovalStatus(AllGovernanceStatus.ACCEPTED);
          action.apply();

          action.execute();

          statuses.add(AllGovernanceStatus.ACCEPTED);
        }
        else if (action.getApprovalStatus().contains(AllGovernanceStatus.ACCEPTED))
        {
          action.execute();

          statuses.add(AllGovernanceStatus.ACCEPTED);
        }
        else if (action.getApprovalStatus().contains(AllGovernanceStatus.REJECTED) || action.getApprovalStatus().contains(AllGovernanceStatus.INVALID))
        {
          statuses.add(AllGovernanceStatus.REJECTED);
        }
      }

      AllGovernanceStatus status = AllGovernanceStatus.REJECTED;

      if (statuses.size() > 0)
      {
        status = statuses.size() == 1 ? statuses.iterator().next() : AllGovernanceStatus.PARTIAL;
      }

      this.appLock();
      this.setMaintainerNotes(maintainerNotes);
      this.setAdditionalNotes(additionalNotes);
      this.clearApprovalStatus();
      this.addApprovalStatus(status);
      this.apply();

      // Email the contributor
      try
      {
        SingleActor actor = this.getCreatedBy();
  
        if (actor instanceof GeoprismUser)
        {
          String email = ( (GeoprismUser) actor ).getEmail();
  
          if (email != null && email.length() > 0 && !email.contains("@noreply"))
          {
            final String statusLabel = status.getDisplayLabel().toLowerCase(Session.getCurrentLocale());
            
            String subject = LocalizationFacade.getFromBundles("change.request.email.implement.subject");
            subject = subject.replaceAll("\\{status\\}", StringUtils.capitalize(statusLabel));
  
            String body = LocalizationFacade.getFromBundles("change.request.email.implement.body");
            body = body.replaceAll("\\\\n", "\n");
            body = body.replaceAll("\\{status\\}", statusLabel);
            body = body.replaceAll("\\{geoobject\\}", this.getGeoObject().getDisplayLabel().getValue());
            
            String link = GeoregistryProperties.getRemoteServerUrl() + "cgr/manage#/registry/change-requests/" + this.getOid();
            body = body.replaceAll("\\{link\\}", link);
  
             EmailSetting.sendEmail(subject, body, new String[] { email });
          }
        }
      }
      catch(Throwable t)
      {
        t.printStackTrace();
      }
    }
  }
  
  @Transaction
  public void setAllActionsStatus(AllGovernanceStatus status)
  {
    OIterator<? extends AbstractAction> it = this.getAllAction();

    try
    {
      while (it.hasNext())
      {
        AbstractAction action = it.next();

        // if (!status.equals(AllGovernanceStatus.ACCEPTED) ||
        // action.getApprovalStatus().contains(AllGovernanceStatus.PENDING))
        // {
        action.appLock();
        action.clearApprovalStatus();
        action.addApprovalStatus(status);
        action.apply();
        // }
      }
    }
    finally
    {
      it.close();
    }

    // if (status.equals(AllGovernanceStatus.REJECTED))
    // {
    // this.appLock();
    // this.clearApprovalStatus();
    // this.addApprovalStatus(AllGovernanceStatus.REJECTED);
    // this.apply();
    // }
  }

  public boolean isCurrentUserOwner()
  {
    return this.getOwnerId().equals(Session.getCurrentSession().getUser().getOid());
  }

  public AllGovernanceStatus getGovernanceStatus()
  {
    return this.getApprovalStatus().get(0);
  }

  @Transaction
  public void invalidate(String localizedReason)
  {
    this.lock();

    this.clearApprovalStatus();
    this.addApprovalStatus(AllGovernanceStatus.INVALID);

    if (this.getMaintainerNotes() != null && this.getMaintainerNotes().length() > 0)
    {
      this.setMaintainerNotes(this.getMaintainerNotes() + " " + localizedReason);
    }
    else
    {
      this.setMaintainerNotes(localizedReason);
    }

    List<AbstractAction> actions = this.getOrderedActions();

    for (AbstractAction action : actions)
    {
      action.lock();

      if (action.getMaintainerNotes() != null && action.getMaintainerNotes().length() > 0)
      {
        action.setMaintainerNotes(action.getMaintainerNotes() + " " + localizedReason);
      }
      else
      {
        action.setMaintainerNotes(localizedReason);
      }

      action.apply();
    }

    this.apply();
  }

}
