package fr.apside.formation;

import fr.apside.formation.model.Person;
import fr.apside.formation.model.Training;
import fr.apside.formation.services.BaseService;
import fr.apside.formation.services.PersonService;
import fr.apside.formation.test.EjbTest;
import org.junit.Test;

import javax.naming.NamingException;

import java.time.Period;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author François Robert
 */
public class ServicesTest extends EjbTest {

  @Test
  public void testBaseService() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    assertNotNull(baseService);
    assertEquals("hello", baseService.sayHello());
  }

  @Test
  public void getPersonList() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    List<Person> personList = baseService.getPersonList();
    assertNotNull(personList);
  }

  @Test
  public void createPerson() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    Person person = baseService.createPerson("login", "surname", "firstname");
    assertNotNull(person);
    assertNotNull(person.getId());
  }

  @Test
  public void getPersonById() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    baseService.createPerson("login", "surname", "firstname");
    Person person = baseService.getPersonById(1L);
    assertNotNull(person);
  }

  @Test
  public void getPersonByLogin() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    baseService.createPerson("login", "surname", "firstname");
    Person person = baseService.getPersonByLogin("login");
    assertNotNull(person);
  }

  @Test
  public void mergePerson() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    baseService.createPerson("login", "surname", "firstname");
    Person personDatabase = baseService.getPersonByLogin("login");
    personDatabase.setFirstname("thor");
    baseService.mergePerson(personDatabase);
  }

  @Test
  public void deletePerson() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    Long personToDeleteId = baseService.createPerson("login", "surname", "firstname").getId();
    Person personToDelete = baseService.deletePerson(personToDeleteId);
    assertNotNull(personToDelete);
    Person personDeleted = baseService.getPersonById(personToDeleteId);
    assertNull(personDeleted);
  }

  @Test
  public void getTrainingListForPerson() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    Person person = baseService.createPerson("login", "surname", "firstname");
    // création de liste de formation et affectation :)
    List<Training> trainingList = baseService.getTrainingListForPerson(person);
    assertNotNull(trainingList);
  }

}
