package fr.apside.formation;

import fr.apside.formation.model.Person;
import fr.apside.formation.test.JpaTest;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author François Robert
 */

public class TestPerson extends JpaTest {

  private static EntityManagerFactory entityManagerFactory;
  private static EntityManager entityManager;

  @Test
  public void testPerson() {
    /*
    Person person = new Person();
    person.setId(1L);
    person.setLogin("toto");
    persist(person);
    */
  }


}
