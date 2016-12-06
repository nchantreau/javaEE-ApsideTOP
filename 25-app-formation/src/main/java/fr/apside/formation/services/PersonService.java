package fr.apside.formation.services;

import fr.apside.formation.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author François Robert
 */
@Stateless
public class PersonService implements Serializable {

  private static final long serialVersionUID = -1680965529303581391L;

  @PersistenceContext
  private EntityManager entityManager;

  public Person createPerson(String login, String surname, String firstname) {
    Person person = new Person(login, surname, firstname);
    entityManager.persist(person);
    return person;
  }

  public List<Person> findAll() {
    return entityManager.createNamedQuery(Person.FIND_ALL_ORDER_BY_LOGIN, Person.class)
        .getResultList();
  }

  /**
   * Renvoi la liste de personne selon une page et une taille de page (nombre d'enregistement retourné)
   * Si la page demandé est inférieur à 1, c'est la page 1 qui est retourné par défaut (pas un bon pattern, mais c'est pour les tests)
   * @param page page (les page commence à 1
   * @param pageSize taile (en enregistrement) de la page
   * @return liste
   */
  public List<Person> findAll(int page, int pageSize) {
    return entityManager.createNamedQuery(Person.FIND_ALL_ORDER_BY_LOGIN, Person.class)
        .setFirstResult((page <= 1 ? 0 : ((page - 1) * pageSize)))
        .setMaxResults(pageSize)
        .getResultList();
  }

  /**
   * Renvoi une personne selon son login, si non trouvé, alors renvoi null
   * @param login login
   * @return personne trouvé ou null
   */
  public Person findByLogin(String login) {
    try {
      return entityManager.createNamedQuery(Person.FIND_BY_LOGIN, Person.class)
          .setParameter(Person.LOGIN, login)
          .getSingleResult();
    } catch (NoResultException | NonUniqueResultException e) {
      return null;
    }
  }

  /**
   * Persiste les donnée en base
   * @param person personne a persister
   */
  public void merge(Person person) {
    entityManager.merge(person);
  }

  /**
   * Renvoi une personne en fonction de son Id (PK)
   * @param personId identifiant (PK) de la personne
   * @return personne ou null
   */
  public Person findById(long personId) {
    return entityManager.find(Person.class, personId);
  }

  /**
   * Supprime une personne (suppression en base) en renvoyant la dernière version de celle-ci. Si la personne n'existe pas null est renvoyé
   * @param personToDelete personne a supprimer
   * @return personne (last version) ou null
   */
  public Person delete(Person personToDelete) {
    Person person = findById(personToDelete.getId());
    if (person != null) {
      entityManager.remove(person);
    }
    return person;
  }
}
