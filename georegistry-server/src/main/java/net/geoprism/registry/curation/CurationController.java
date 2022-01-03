package net.geoprism.registry.curation;

import com.google.gson.JsonObject;
import com.runwaysdk.constants.ClientRequestIF;
import com.runwaysdk.controller.ServletMethod;
import com.runwaysdk.mvc.Controller;
import com.runwaysdk.mvc.Endpoint;
import com.runwaysdk.mvc.ErrorSerialization;
import com.runwaysdk.mvc.RequestParamter;
import com.runwaysdk.mvc.ResponseIF;
import com.runwaysdk.mvc.RestBodyResponse;
import com.runwaysdk.mvc.RestResponse;

@Controller(url = "curation")
public class CurationController
{
  protected CurationService service;

  public CurationController()
  {
    this.service = new CurationService();
  }

  @Endpoint(method = ServletMethod.GET, error = ErrorSerialization.JSON, url = "details")
  public ResponseIF details(ClientRequestIF request, @RequestParamter(name = "historyId") String historyId, @RequestParamter(name = "onlyUnresolved") Boolean onlyUnresolved, @RequestParamter(name = "pageSize") Integer pageSize, @RequestParamter(name = "pageNumber") Integer pageNumber)
  {
    JsonObject details = this.service.details(request.getSessionId(), historyId, onlyUnresolved, pageSize, pageNumber);

    return new RestBodyResponse(details.toString());
  }

  @Endpoint(method = ServletMethod.GET, error = ErrorSerialization.JSON, url = "page")
  public ResponseIF page(ClientRequestIF request, @RequestParamter(name = "historyId") String historyId, @RequestParamter(name = "onlyUnresolved") Boolean onlyUnresolved, @RequestParamter(name = "pageSize") Integer pageSize, @RequestParamter(name = "pageNumber") Integer pageNumber)
  {
    JsonObject page = this.service.page(request.getSessionId(), historyId, onlyUnresolved, pageSize, pageNumber);

    return new RestBodyResponse(page.toString());
  }

  @Endpoint(method = ServletMethod.POST, error = ErrorSerialization.JSON, url = "curate")
  public ResponseIF curate(ClientRequestIF request, @RequestParamter(name = "listTypeVersionId") String listTypeVersionId)
  {
    JsonObject serializedHistory = this.service.curate(request.getSessionId(), listTypeVersionId);

    return new RestBodyResponse(serializedHistory.toString());
  }

  @Endpoint(method = ServletMethod.POST, error = ErrorSerialization.JSON, url = "problem-resolve")
  public ResponseIF submitProblemResolution(ClientRequestIF request, @RequestParamter(name = "config") String config)
  {
    this.service.submitProblemResolution(request.getSessionId(), config);

    return new RestResponse();
  }

  @Endpoint(method = ServletMethod.POST, error = ErrorSerialization.JSON, url = "set-resolution")
  public ResponseIF setResolution(ClientRequestIF request, @RequestParamter(name = "problemId") String problemId, @RequestParamter(name = "resolution") String resolution)
  {
    this.service.setResolution(request.getSessionId(), problemId, resolution);

    return new RestResponse();
  }

}