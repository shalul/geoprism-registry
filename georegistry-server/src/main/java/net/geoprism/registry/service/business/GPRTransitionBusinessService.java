package net.geoprism.registry.service.business;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.commongeoregistry.adapter.dataaccess.LocalizedValue;

import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.system.Roles;

import net.geoprism.registry.business.TransitionBusinessService;
import net.geoprism.registry.business.TransitionBusinessServiceIF;
import net.geoprism.registry.conversion.RegistryLocalizedValueConverter;
import net.geoprism.registry.graph.transition.Transition;
import net.geoprism.registry.graph.transition.Transition.TransitionType;
import net.geoprism.registry.graph.transition.TransitionEvent;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.ServerHierarchyType;
import net.geoprism.registry.model.graph.VertexServerGeoObject;
import net.geoprism.registry.task.Task;
import net.geoprism.registry.task.Task.TaskType;

public class GPRTransitionBusinessService extends TransitionBusinessService implements TransitionBusinessServiceIF
{
  @Override
  public void delete(Transition tran)
  {
    super.delete(tran);

    Task.removeTasks(tran.getOid());
  }
  
  @Override
  @Transaction
  public void apply(Transition tran, TransitionEvent event, int order, VertexServerGeoObject source, VertexServerGeoObject target)
  {
    boolean isModified = tran.isModified(Transition.TARGET);
    boolean isNew = tran.isNew() && !tran.isAppliedToDb();

    super.apply(tran, event, order, source, target);

    if (isNew || isModified)
    {
      Task.removeTasks(tran.getOid());

      this.createTask(tran, source, target, event.getEventDate());
    }
  }
  
  public void createTask(Transition tran, VertexServerGeoObject source, VertexServerGeoObject target, Date eventDate)
  {
    LocalizedValue dateValue = RegistryLocalizedValueConverter.convert(eventDate);

    TransitionType transitionType = tran.toTransitionType();
    ServerGeoObjectType sourceType = source.getType();
    ServerGeoObjectType targetType = target.getType();

    List<ServerGeoObjectType> types = Arrays.asList(new ServerGeoObjectType[] { sourceType, targetType }).stream().distinct().collect(Collectors.toList());

    for (ServerGeoObjectType type : types)
    {
      List<ServerHierarchyType> hierarchies = gotServ.getHierarchies(type);

      for (ServerHierarchyType hierarchy : hierarchies)
      {
        List<ServerGeoObjectType> children = gotServ.getChildren(type, hierarchy);

        for (ServerGeoObjectType child : children)
        {
          List<Roles> roles = Arrays.asList(new String[] { ((GPRGeoObjectTypeBusinessService)gotServ).getMaintainerRoleName(child), ((GPRGeoObjectTypeBusinessService) gotServ).getAdminRoleName(child) }).stream().distinct().map(name -> Roles.findRoleByName(name)).collect(Collectors.toList());

          HashMap<String, LocalizedValue> values = new HashMap<String, LocalizedValue>();
          values.put("1", source.getDisplayLabel());
          values.put("2", sourceType.getLabel());
          values.put("3", target.getDisplayLabel());
          values.put("4", targetType.getLabel());
          values.put("5", child.getLabel());
          values.put("6", hierarchy.getLabel());
          values.put("7", dateValue);

          TaskType taskType = Task.TaskType.SPLIT_EVENT_TASK;

          if (transitionType.isMerge())
          {
            taskType = Task.TaskType.MERGE_EVENT_TASK;
          }
          else if (transitionType.isReassign())
          {
            taskType = Task.TaskType.REASSIGN_EVENT_TASK;
          }

          Task.createNewTask(roles, taskType, values, tran.getOid());
        }
      }
    }
  }
}
