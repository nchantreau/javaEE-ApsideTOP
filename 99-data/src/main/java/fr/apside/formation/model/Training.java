package fr.apside.formation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  private Date startDate;

  private Integer duration;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "training_category"
      , joinColumns = {@JoinColumn(name = "tc_training_id", referencedColumnName = "training_id")}
      , inverseJoinColumns = {@JoinColumn(name = "tc_category_id", referencedColumnName = "category_id")}
  )
  private Set<Category> categorySet;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "training")
  private Set<Participation> participationSet;

  /*
  private Date limiteDateForParticipation;
  */

  public Training() {
  }

  public Training(String name, Date startDate) {
    this.name = name;
    this.startDate = startDate;
  }

  public Training(TrainingType type) {
    this.type = type;
  }

  public Training(TrainingType type, String name, Date startDate) {
    this.type = type;
    this.name = name;
    this.startDate = startDate;
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

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Set<Participation> getParticipationSet() {
    return participationSet;
  }

  public void setParticipationSet(Set<Participation> participationSet) {
    this.participationSet = participationSet;
  }

  public Set<Category> getCategorySet() {
    return categorySet;
  }

  public void setCategorySet(Set<Category> categorySet) {
    this.categorySet = categorySet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Training)) return false;
    Training training = (Training) o;
    return Objects.equals(getName(), training.getName()) &&
        Objects.equals(getStartDate(), training.getStartDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getStartDate());
  }
}
