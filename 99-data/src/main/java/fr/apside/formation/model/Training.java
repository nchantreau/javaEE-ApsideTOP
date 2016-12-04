package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author François Robert
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("UNKNOW")
public class Training implements Serializable {

  private static final long serialVersionUID = -7688108012987555188L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "training_id")
  private Long Id;

  @Enumerated(EnumType.STRING)
  private TrainingType type;

  private String name;

  @ManyToOne
  @JoinColumn(name = "training_person_id")
  private Person former;

  /*
  private Set<Category> categorySet;


  private Set<Person> participantSet;

  private Date startDate;

  private Integer duration;

  private Date limiteDateForParticipation;
  */

  public Training() {
  }

  public Training(TrainingType type) {
    this.type = type;
  }

  public Training(TrainingType type, String name) {
    this.type = type;
    this.name = name;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public TrainingType getType() {
    return type;
  }

  public void setType(TrainingType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person getFormer() {
    return former;
  }

  public void setFormer(Person former) {
    this.former = former;
  }
}
