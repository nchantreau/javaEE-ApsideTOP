package fr.apside.formation.ws.rs;

import fr.apside.formation.model.Person;
import fr.apside.formation.services.PersonService;
import fr.apside.formation.ws.bean.PersonDTO;
import fr.apside.formation.ws.bean.converter.PersontDTOConverter;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author François Robert
 */
@Path("people")
public class PersonRest implements PersontDTOConverter {

  @EJB
  private PersonService personService;

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public List<PersonDTO> getPersonList() {
    return personService.findAll().stream().map(this::toDTO).collect(Collectors.toList());
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response createUser(
      @FormParam("login") String login
      , @FormParam("surname") String surname
      , @FormParam("firstname") String firstname
      , @Context HttpHeaders httpHeaders
      ) {
    Person person = personService.createPerson(login, surname, firstname);
    //...
    return Response
        .created(
            UriBuilder
                .fromResource(PersonRest.class)
                .path(String.valueOf(person.getId()))
                .build()
        )
        .entity(
            httpHeaders
                .getAcceptableMediaTypes().contains(MediaType.WILDCARD_TYPE) ? null : toDTO(person)
        )
        .build();
  }
}


/*
    return Response
        .created(UriBuilder.fromResource(UserEndPoint.class).path(user.getId()).build())
        .entity(httpHeaders.getAcceptableMediaTypes().contains(MediaType.WILDCARD_TYPE) ? null : user)
        .build();

 */