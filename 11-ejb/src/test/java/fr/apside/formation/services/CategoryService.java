package fr.apside.formation.services;

import fr.apside.formation.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 * @author François Robert
 */
@Stateless
public class CategoryService {

  @PersistenceContext
  private EntityManager entityManager;

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
}
