package net.geoprism.registry.curation;

@com.runwaysdk.business.ClassSignature(hash = -717562880)
/**
 * This class is generated automatically.
 * DO NOT MAKE CHANGES TO IT - THEY WILL BE OVERWRITTEN
 * Custom business logic should be added to ListCurationJob.java
 *
 * @author Autogenerated by RunwaySDK
 */
public class ListCurationJobQueryDTO extends com.runwaysdk.system.scheduler.ExecutableJobQueryDTO
{
private static final long serialVersionUID = -717562880;

  protected ListCurationJobQueryDTO(String type)
  {
    super(type);
  }

@SuppressWarnings("unchecked")
public java.util.List<? extends net.geoprism.registry.curation.ListCurationJobDTO> getResultSet()
{
  return (java.util.List<? extends net.geoprism.registry.curation.ListCurationJobDTO>)super.getResultSet();
}
}