package fr.apside.formation.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author François Robert
 */
@Stateless
public class CategoryService implements Serializable {

  private static final long serialVersionUID = 5648728719090132556L;

  @PersistenceContext
  private EntityManager entityManager;
/*
  public Category findByName(String name) {
    try {
      return entityManager.createNamedQuery(Category.FIND_BY_NAME, Category.class)
          .setParameter(Category.NAME, name)
          .getSingleResult();
    } catch (NonUniqueResultException | NoResultException e) {
      return null;
    }
  }

  public Category create(String categoryName) {
    Category category = new Category(categoryName);
    entityManager.persist(category);
    return category;
  }
  */
}
