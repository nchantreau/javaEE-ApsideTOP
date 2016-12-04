package fr.apside.formation.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * @author François Robert
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

  private static final long serialVersionUID = 6132112112831771298L;

  @Id
  @Column(name = "CATEGORY_ID")
  private Long id;

  @Column(name = "CATEGORY_NAME", length = 100)
  private String name;

  @ManyToMany
  private Set<Training> trainingSet;

  public Category() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Training> getTrainingSet() {
    return trainingSet;
  }

  public void setTrainingSet(Set<Training> trainingSet) {
    this.trainingSet = trainingSet;
  }

  @Override
  public String toString() {
    return "Category{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
