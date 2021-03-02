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
package net.geoprism.registry.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.runwaysdk.constants.ClientRequestIF;
import com.runwaysdk.controller.ServletMethod;
import com.runwaysdk.mvc.Controller;
import com.runwaysdk.mvc.Endpoint;
import com.runwaysdk.mvc.ErrorSerialization;
import com.runwaysdk.mvc.RequestParamter;
import com.runwaysdk.mvc.ResponseIF;
import com.runwaysdk.mvc.RestBodyResponse;
import com.runwaysdk.mvc.RestResponse;

import net.geoprism.registry.service.ChangeRequestService;

/**
 * This controller is used by the change request table widget.
 * 
 * @author rrowlands
 *
 */
@Controller(url = "changerequest")
public class ChangeRequestController
{
  private ChangeRequestService service;

  public ChangeRequestController()
  {
    this.service = new ChangeRequestService();
  }
  
  @Endpoint(error = ErrorSerialization.JSON)
  public ResponseIF unlockAction(ClientRequestIF request, @RequestParamter(name = "actionId") String actionId) throws JSONException
  {
    String sAction = service.unlockAction(request.getSessionId(), actionId);

    return new RestBodyResponse(sAction);
  }
  
  @Endpoint(error = ErrorSerialization.JSON)
  public ResponseIF lockAction(ClientRequestIF request, @RequestParamter(name = "actionId") String actionId) throws JSONException
  {
    String sResponse = service.lockAction(request.getSessionId(), actionId);
    
    return new RestBodyResponse(sResponse);
  }

  /**
   * Submits a serialized action to be applied to the database.
   * 
   * @pre The action has already been locked.
   * @post The action will be applied
   * @post The action will no longer be locked
   * 
   * @param request
   * @param action
   * @return
   * @throws JSONException
   */
  @Endpoint(error = ErrorSerialization.JSON)
  public ResponseIF applyAction(ClientRequestIF request, @RequestParamter(name = "action") String action) throws JSONException
  {
    service.applyAction(request.getSessionId(), action);

    return new RestResponse();
  }
  
  @Endpoint(error = ErrorSerialization.JSON)
  public ResponseIF applyActionStatusProperties(ClientRequestIF request, @RequestParamter(name = "action") String action) throws JSONException
  {
    service.applyActionStatusProperties(request.getSessionId(), action);

    return new RestResponse();
  }
  
  /**
   * Gets all actions in the system ordered by createActionDate. If a requestId is provided we will fetch the actions that
   * are relevant to that Change Request.
   * 
   * @param request
   * @param requestId
   * @return
   * @throws JSONException
   */
  @Endpoint(error = ErrorSerialization.JSON)
  public ResponseIF getAllActions(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId) throws JSONException
  {
    String json = service.getAllActions(request.getSessionId(), requestId);

    return new RestBodyResponse(json);
  }

  @Endpoint(error = ErrorSerialization.JSON, url = "get-all-requests", method = ServletMethod.GET)
  public ResponseIF getAllRequests(ClientRequestIF request, @RequestParamter(name = "filter") String filter) throws JSONException
  {
    JSONArray requests = service.getAllRequests(request.getSessionId(), filter);

    return new RestBodyResponse(requests);
  }

  @Endpoint(error = ErrorSerialization.JSON, url = "get-request-details", method = ServletMethod.GET)
  public ResponseIF getRequestDetails(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId) throws JSONException
  {
    JSONObject response = service.getRequestDetails(request.getSessionId(), requestId);

    return new RestBodyResponse(response);
  }
  
  @Endpoint(error = ErrorSerialization.JSON, url = "execute-actions", method = ServletMethod.POST)
  public ResponseIF executeActions(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId) throws JSONException
  {
    JSONObject response = service.executeActions(request.getSessionId(), requestId);

    return new RestBodyResponse(response);
  }
  
  @Endpoint(error = ErrorSerialization.JSON, url = "confirm-change-request", method = ServletMethod.POST)
  public ResponseIF confirmChangeRequest(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId) throws JSONException
  {
    JSONObject response = service.confirmChangeRequest(request.getSessionId(), requestId);

    return new RestBodyResponse(response);
  }

  @Endpoint(error = ErrorSerialization.JSON, url = "approve-all-actions", method = ServletMethod.POST)
  public ResponseIF approveAllActions(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId, @RequestParamter(name = "actions") String actions) throws JSONException
  {
    String response = service.approveAllActions(request.getSessionId(), requestId, actions);

    return new RestBodyResponse(response);
  }

  @Endpoint(error = ErrorSerialization.JSON, url = "reject-all-actions", method = ServletMethod.POST)
  public ResponseIF rejectAllActions(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId, @RequestParamter(name = "actions") String actions) throws JSONException
  {
    String response = service.rejectAllActions(request.getSessionId(), requestId, actions);

    return new RestBodyResponse(response);
  }
  
  @Endpoint(error = ErrorSerialization.JSON, url = "delete", method = ServletMethod.POST)
  public ResponseIF deleteChangeRequest(ClientRequestIF request, @RequestParamter(name = "requestId") String requestId) throws JSONException
  {
    service.deleteChangeRequest(request.getSessionId(), requestId);

    return new RestResponse();
  }
}
