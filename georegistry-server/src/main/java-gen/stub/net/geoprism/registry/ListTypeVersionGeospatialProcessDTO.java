package net.geoprism.registry;

public class ListTypeVersionGeospatialProcessDTO extends ListTypeVersionGeospatialProcessDTOBase
{
  private static final long serialVersionUID = -309953003;
  
  public ListTypeVersionGeospatialProcessDTO(com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(clientRequest);
  }
  
  /**
  * Copy Constructor: Duplicates the values and attributes of the given LocalStructDTO into a new DTO.
  * 
  * @param localStructDTO The LocalStructDTO to duplicate
  * @param clientRequest The clientRequest this DTO should use to communicate with the server.
  */
  protected ListTypeVersionGeospatialProcessDTO(com.runwaysdk.business.LocalStructDTO localStructDTO, com.runwaysdk.constants.ClientRequestIF clientRequest)
  {
    super(localStructDTO, clientRequest);
  }
  
}