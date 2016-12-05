package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Set;

/**
 * @author François Robert
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Category.FIND_BY_NAME
        , query = "select c from Category c where c.name = :" + Category.NAME
    )
})
public class Category implements Serializable {

  private static final long serialVersionUID = 6132112112831771298L;
  public static final java.lang.String FIND_BY_NAME = "Category.FIND_BY_NAME";
  public static final String NAME = "categoryName";

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "training_category"
      , joinColumns = {@JoinColumn(name = "tc_category_id", referencedColumnName = "category_id")}
      , inverseJoinColumns = {@JoinColumn(name = "tc_training_id", referencedColumnName = "training_id")}
  )
  private Set<Training> trainingSet;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
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
