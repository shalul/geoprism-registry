package net.geoprism.registry.service;

import java.io.InputStream;

import org.commongeoregistry.adapter.metadata.OrganizationDTO;

import com.runwaysdk.session.Request;
import com.runwaysdk.session.RequestType;

import net.geoprism.registry.model.ServerOrganization;
import net.geoprism.registry.xml.XMLExporter;

public class GPROrganizationService extends OrganizationService implements OrganizationServiceIF
{

  @Request(RequestType.SESSION)
  public InputStream exportTypes(String sessionId, String code)
  {
    ServerOrganization organization = ServerOrganization.getByCode(code);

    XMLExporter exporter = new XMLExporter(organization);
    exporter.build();

    return exporter.write();
  }

  /**
   * Updates the given {@link OrganizationDTO} represented as JSON.
   * 
   * @pre given {@link OrganizationDTO} must already exist.
   * 
   * @param sessionId
   * @param json
   *          JSON of the {@link OrganizationDTO} to be updated.
   * @return updated {@link OrganizationDTO}
   */
  @Override
  public OrganizationDTO updateOrganization(String sessionId, String json)
  {
    OrganizationDTO dto = super.updateOrganization(sessionId, json);

    SerializedListTypeCache.getInstance().clear();

    return dto;
  }

  /**
   * Deletes the {@link OrganizationDTO} with the given code.
   * 
   * @param sessionId
   * @param code
   *          code of the {@link OrganizationDTO} to delete.
   */
  @Request(RequestType.SESSION)
  public void deleteOrganization(String sessionId, String code)
  {
    super.deleteOrganization(sessionId, code);

    SerializedListTypeCache.getInstance().clear();
  }
}
