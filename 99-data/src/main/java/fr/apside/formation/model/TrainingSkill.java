package fr.apside.formation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * @author François Robert
 */
@Entity
@DiscriminatorValue("QUALIFICATIVE")
public class TrainingSkill extends Training implements Serializable {

  private static final long serialVersionUID = -7216249524882960198L;

  private String qualifacationId;

  @ManyToOne
  @JoinColumn(name = "training_place_id")
  private Place place;

  public TrainingSkill() {
    super(TrainingType.QUALIFICATIVE);
  }

  public TrainingSkill(String name, String qualifacationId, Place place, Date startDate) {
    super(TrainingType.QUALIFICATIVE, name, startDate);
    this.qualifacationId = qualifacationId;
    this.place = place;
  }

  public String getQualifacationId() {
    return qualifacationId;
  }

  public void setQualifacationId(String qualifacationId) {
    this.qualifacationId = qualifacationId;
  }

  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }
}
