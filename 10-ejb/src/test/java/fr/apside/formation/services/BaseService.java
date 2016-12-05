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

}
