package net.geoprism.registry.service.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.runwaysdk.session.Request;
import com.runwaysdk.session.RequestType;

import net.geoprism.registry.graph.transition.TransitionEvent;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.service.business.GPRTransitionEventBusinessService;
import net.geoprism.registry.service.permission.GPRGeoObjectPermissionService;

@Service
public class TransitionEventService
{
  @Autowired
  protected GPRTransitionEventBusinessService service;

  @Request(RequestType.SESSION)
  public JsonObject page(String sessionId, Integer pageSize, Integer pageNumber, String attrConditions)
  {
    return service.page(pageSize, pageNumber, attrConditions).toJSON();
  }

  @Request(RequestType.SESSION)
  public JsonObject getDetails(String sessionId, String oid)
  {
    return service.toJSON(TransitionEvent.get(oid), true);
  }

  @Request(RequestType.SESSION)
  public JsonObject apply(String sessionId, JsonObject json)
  {
    return service.apply(json);
  }

  @Request(RequestType.SESSION)
  public void delete(String sessionId, String eventId)
  {
    service.delete(TransitionEvent.get(eventId));
  }

  @Request(RequestType.SESSION)
  public JsonObject getHistoricalReport(String sessionId, String typeCode, Date startDate, Date endDate, Integer pageSize, Integer pageNumber)
  {
    ServerGeoObjectType type = ServerGeoObjectType.get(typeCode);

    new GPRGeoObjectPermissionService().enforceCanRead(type.getOrganization().getCode(), type);

    return this.service.getHistoricalReport(type, startDate, endDate, pageSize, pageNumber).toJSON();
  }

  @Request(RequestType.SESSION)
  public InputStream exportExcel(String sessionId, String typeCode, Date startDate, Date endDate) throws IOException
  {
    ServerGeoObjectType type = ServerGeoObjectType.get(typeCode);

    new GPRGeoObjectPermissionService().enforceCanRead(type.getOrganization().getCode(), type);

    return this.service.exportToExcel(type, startDate, endDate);
  }
}