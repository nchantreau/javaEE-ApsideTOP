package fr.apside.formation.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author François Robert
 */
@WebService(serviceName = "civilizedServiceAccess"
    , portName = "civilizedService"
    , name = "civilizedService"
)
public class CivilizedSOAPWebservice {

  @WebMethod
  public String sayHello(@WebParam String somebody) {
    return "Bonjour " + somebody;
  }

}
