package fr.apside.formation.services;

import fr.apside.formation.model.Person;

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

  @PersistenceContext(unitName = "formationPU")
  private EntityManager entityManager;

  public String sayHello() {
    return "hello";
  }

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  public List<Person> getAllPerson() {
    return entityManager.createNamedQuery(Person.FIND_ALL_ORDER_BY_LOGIN, Person.class)
        .getResultList();
  }

}
