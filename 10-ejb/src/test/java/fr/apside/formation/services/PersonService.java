package fr.apside.formation.services;

import fr.apside.formation.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author François Robert
 */
@Stateless
public class PersonService {

  @PersistenceContext
  private EntityManager entityManager;

  public Person createPerson(String login, String surname, String firstname) {
    return null;
  }

  public List<Person> findAll() {
    return null;
  }

  /**
   * Renvoi la liste de personne selon une page et une taille de page (nombre d'enregistement retourné)
   * Si la page demandé est inférieur à 1, c'est la page 1 qui est retourné par défaut (pas un bon pattern, mais c'est pour les tests)
   * @param page page (les page commence à 1)
   * @param pageSize taile (en enregistrement) de la page
   * @return liste
   */
  public List<Person> findAll(int page, int pageSize) {
    return null;
  }

  /**
   * Renvoi une personne selon son login, si non trouvé, alors renvoi null
   * @param login login
   * @return personne trouvé ou null
   */
  public Person findByLogin(String login) {
    return null;
  }

  /**
   * Persiste les donnée en base
   * @param person personne a persister
   */
  public void merge(Person person) {
  }

  /**
   * Renvoi une personne en fonction de son Id (PK)
   * @param personId identifiant (PK) de la personne
   * @return personne ou null
   */
  public Person findById(long personId) {
    return null;
  }

  /**
   * Supprime une personne (suppression en base) en renvoyant la dernière version de celle-ci. Si la personne n'existe pas null est renvoyé
   * @param personToDelete personne a supprimer
   * @return personne (last version) ou null
   */
  public Person delete(Person personToDelete) {
    return null;
  }

}
