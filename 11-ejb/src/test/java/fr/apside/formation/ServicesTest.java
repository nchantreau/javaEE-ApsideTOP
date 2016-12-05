package fr.apside.formation;

import fr.apside.formation.model.Person;
import fr.apside.formation.model.Training;
import fr.apside.formation.services.BaseService;
import fr.apside.formation.services.PersonService;
import fr.apside.formation.test.EjbTest;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NamingException;

import java.time.Period;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author François Robert
 */
public class ServicesTest extends EjbTest {

  @Test
  public void testPersonServiceCreate() throws Exception {
    PersonService personService = lookup(PersonService.class);
    assertNotNull(personService);
    Person person = personService.createPerson("ironMan", "Stark", "Anthony");
    assertNotNull(person);
    assertNotNull(person.getId());
    assertEquals(new Long(1L), person.getId());
  }

  @Test
  public void testPersonServiceFindAll() throws Exception {
    PersonService personService = lookup(PersonService.class);
    final int personMaxCount = 100;
    for (int idx = 0; idx < personMaxCount; idx++) {
      personService.createPerson("login" + String.format ("%03d", personMaxCount - idx), "surname_" + idx, "firstname-" + idx);
    }
    List<Person> personList = personService.findAll();
    assertNotNull(personList);
    assertTrue(personList.size() > 0);
    List<Person> paginatedPersonList = personService.findAll(2, 10);
    assertNotNull(paginatedPersonList);
    assertTrue(paginatedPersonList.size() == 10);
    Person person = paginatedPersonList.get(0);
    assertEquals(new Long(90L), person.getId());
    assertEquals("login011", person.getLogin());
  }

  @Test
  public void testPersonServiceFindByLoginAndMergeAndDelete() throws Exception {
    PersonService personService = lookup(PersonService.class);
    assertNotNull(personService);
    personService.createPerson("ironMan", "Stark", "Anthony");
    //---
    Person ironman = personService.findByLogin("ironMan");
    assertNotNull(ironman);
    assertEquals("Anthony", ironman.getFirstname());
    ironman.setFirstname(ironman.getFirstname() + " Junior");
    personService.merge(ironman);
    Person anthonyStarkJunior = personService.findById(1L);
    assertNotNull(anthonyStarkJunior);
    assertNotEquals("Anthony", ironman.getFirstname());
    assertEquals("Anthony Junior", ironman.getFirstname());
    Person deletedAnthonyStarkJunior = personService.delete(anthonyStarkJunior);
    assertNotNull(deletedAnthonyStarkJunior);
    assertNull(personService.findById(anthonyStarkJunior.getId()));
    Person deletedIronman = personService.delete(ironman);
    assertNull(deletedIronman);
  }

}
