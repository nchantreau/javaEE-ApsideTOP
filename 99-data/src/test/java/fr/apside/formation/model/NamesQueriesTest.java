package fr.apside.formation.model;

import fr.apside.formation.test.JpaTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author François Robert
 */
public class NamesQueriesTest extends JpaTest {

  @Test
  public void testPersonList() {
    addingPersons();
    List<Person> personList = getPersonOrderByLogin();
    assertNotNull(personList);
    assertTrue(personList.size() >= 5);
    Person zephir = getPersonByLogin("zephir");
    assertNotNull(zephir);
    assertEquals("zephir", zephir.getLogin());
    Person toto = getPersonByLogin("toto");
    assertNull(toto);
  }



  @Test
  public void testParticipationQuery() {
    addingPersons();
    Training training1 = persist(new TrainingAgency("formation1", "room51", new Date()));
    Training training2 = persist(new TrainingAgency("formation2", "salle-I", new Date()));
    getPersonOrderByLogin().stream().forEach(person -> persist(new Participation(training1, person)));
    getPersonOrderByLogin().stream().filter(person -> person.getLogin().startsWith("a")).forEach(person -> persist(new Participation(training2, person)));
    List<Person> personInFormation2 = getPersonInTraining("formation2");
  }

  private List<Person> getPersonInTraining(String trainingName) {
    return entityManager.createNamedQuery(Participation.FIND_PERSON_FOR_TRAINING, Person.class)
        .setParameter(Training.NAME, trainingName)
        .getResultList();
  }

  private Person getPersonByLogin(String login) {
    try {
      return entityManager.createNamedQuery(Person.FIND_BY_LOGIN, Person.class)
          .setParameter(Person.LOGIN, login)
          .getSingleResult();
    } catch (NoResultException | NonUniqueResultException e) {
      return null;
    }
  }

  private void addingPersons() {
    persist(new Person("abc", "surname", "firstname"));
    persist(new Person("zephir", "surname", "firstname"));
    persist(new Person("test", "surname", "firstname"));
    persist(new Person("abbot", "surname", "firstname"));
    persist(new Person("tony", "surname", "firstname"));
  }

  /**
   * @return liste des personne ordonnée
   */
  private List<Person> getPersonOrderByLogin() {
    return entityManager.createNamedQuery(Person.FIND_ALL_ORDER_BY_LOGIN, Person.class)
        .getResultList();
  }

}
