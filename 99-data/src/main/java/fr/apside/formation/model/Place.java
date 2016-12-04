package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author François Robert
 */
@Entity
public class Place implements Serializable {

  private static final long serialVersionUID = -6091754953574861012L;

  @Id
  @Column(name = "place_id")
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private String name;

  public Place() {
  }

  public Place(String name) {
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

}
