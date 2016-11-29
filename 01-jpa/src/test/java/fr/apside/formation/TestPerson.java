package fr.apside.formation;

import fr.apside.formation.model.Person;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author François Robert
 */

public class TestPerson {

  private static EntityManagerFactory entityManagerFactory;
  private static EntityManager entityManager;

  @Test
  public void testPerson() {
    Person person = new Person();
    person.setId(1L);
    person.setLogin("toto");
    persist(person);
  }

  @BeforeClass
  public static void setUp() {
    entityManagerFactory = Persistence.createEntityManagerFactory("formationPU");
    entityManager = entityManagerFactory.createEntityManager();
  }

  @AfterClass
  public static void tearDown() {
    if (entityManager != null) {
      entityManager.close();
    }
    if (entityManagerFactory != null) {
      entityManagerFactory.close();
    }
  }

  protected <E> E persist(E entity) {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();
    entityManager.persist(entity);
    entityTransaction.commit();
    return entity;
  }


}
