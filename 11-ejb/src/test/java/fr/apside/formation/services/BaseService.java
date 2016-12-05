package fr.apside.formation.services;

import fr.apside.formation.model.Person;
import fr.apside.formation.model.Training;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author François Robert
 */
@Stateless
public class BaseService {


  public String sayHello() {
    return "hello";
  }

  /**
   * Renvoi la liste de personne
   * @return liste
   */
  public List<Person> getPersonList() {
    return null;
  }

  public Person getPersonById(Long personId) {
    return null;
  }

  public Person getPersonByLogin(String login) {
    return null;
  }

  public Person createPerson(String login, String surname, String firstname) {
    return null;
  }

  public Person mergePerson(Person person) {
    return person;
  }

  public Person deletePerson(Long personId) {
    return null;
  }

  public List<Training> getTrainingListForPerson(Person person) {
    return null;
  }

}
