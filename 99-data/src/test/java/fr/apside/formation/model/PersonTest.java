package fr.apside.formation.model;

import fr.apside.formation.test.JpaTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author François Robert
 */
public class PersonTest extends JpaTest {

  @Test
  public void personTest() {
    Person person = new Person("login", "surname", "firstname");
    person = persist(person);
    Address address = new Address("line", "zipcode", "city");
    address.setPerson(person);
    persist(address);
  }

  @Test
  public void simpleTestWithEntityManager() {
    Person person = new Person("login", "surname", "firstname");
    persist(person);
    Long personId = person.getId();
    entityManager.detach(person);
    Person samePerson = entityManager.find(Person.class, personId);
    assertNotNull(samePerson);
    assertEquals(person.getId(), samePerson.getId());
  }
}
