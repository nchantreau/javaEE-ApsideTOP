package fr.apside.formation.ws.soap;

import fr.apside.formation.model.Person;
import fr.apside.formation.services.PersonService;
import fr.apside.formation.ws.bean.PersonDTO;
import fr.apside.formation.ws.bean.converter.PersontDTOConverter;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author François Robert
 */
@WebService(serviceName = "personServiceAccess", portName = "personService", name = "personService")
public class PersonSOAPWebservice implements PersontDTOConverter {

  @EJB
  private PersonService personService;

  @WebMethod
  public List<PersonDTO> getPersonList() {
    return personService.findAll().stream().map(this::toDTO).collect(Collectors.toList());
  }
}
