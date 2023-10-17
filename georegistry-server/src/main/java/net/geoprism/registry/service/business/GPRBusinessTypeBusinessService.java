package net.geoprism.registry.service.business;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.runwaysdk.business.BusinessFacade;
import com.runwaysdk.business.rbac.Operation;
import com.runwaysdk.business.rbac.RoleDAO;
import com.runwaysdk.dataaccess.MdEdgeDAOIF;
import com.runwaysdk.dataaccess.MdVertexDAOIF;
import com.runwaysdk.system.Roles;

import ca.uhn.fhir.rest.annotation.Transaction;
import net.geoprism.registry.BusinessType;
import net.geoprism.registry.RegistryConstants;
import net.geoprism.registry.business.BusinessTypeBusinessService;
import net.geoprism.registry.business.BusinessTypeBusinessServiceIF;

@Service
@Primary
public class GPRBusinessTypeBusinessService extends BusinessTypeBusinessService implements BusinessTypeBusinessServiceIF
{
  @Override
  @Transaction
  public BusinessType apply(JsonObject object)
  {
    BusinessType type = super.apply(object);

    // Assign permissions
    Roles role = Roles.findRoleByName(RegistryConstants.REGISTRY_SUPER_ADMIN_ROLE);
    
    MdVertexDAOIF mdVertex = type.getMdVertexDAO();
    MdEdgeDAOIF mdEdge = type.getMdEdgeDAO();

    RoleDAO roleDAO = (RoleDAO) BusinessFacade.getEntityDAO(role);
    roleDAO.grantPermission(Operation.CREATE, mdVertex.getOid());
    roleDAO.grantPermission(Operation.DELETE, mdVertex.getOid());
    roleDAO.grantPermission(Operation.WRITE, mdVertex.getOid());
    roleDAO.grantPermission(Operation.WRITE_ALL, mdVertex.getOid());

    // Assign edge permissions
    roleDAO.grantPermission(Operation.CREATE, mdEdge.getOid());
    roleDAO.grantPermission(Operation.DELETE, mdEdge.getOid());
    roleDAO.grantPermission(Operation.WRITE, mdEdge.getOid());
    roleDAO.grantPermission(Operation.WRITE_ALL, mdEdge.getOid());
    roleDAO.grantPermission(Operation.ADD_CHILD, mdEdge.getOid());
    roleDAO.grantPermission(Operation.ADD_PARENT, mdEdge.getOid());

    return type;
  }
}