package fr.apside.formation.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author François Robert
 */
public class Training implements Serializable {

  private static final long serialVersionUID = -7688108012987555188L;

  private Long Id;

  private String trainingId;

  private String name;

  private Set<String> tagSet;

  public Training() {
  }

  public Training(Long id, String trainingId, String name, Set<String> tagSet) {
    this();
    Id = id;
    this.trainingId = trainingId;
    this.name = name;
    this.tagSet = tagSet;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getTrainingId() {
    return trainingId;
  }

  public void setTrainingId(String trainingId) {
    this.trainingId = trainingId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getTagSet() {
    return tagSet;
  }

  public void setTagSet(Set<String> tagSet) {
    this.tagSet = tagSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Training)) return false;
    Training training = (Training) o;
    return Objects.equals(getTrainingId(), training.getTrainingId()) &&
        Objects.equals(getName(), training.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTrainingId(), getName());
  }

  @Override
  public String toString() {
    return "Training{" +
        "Id=" + Id +
        ", trainingId='" + trainingId + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
