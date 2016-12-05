package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @author François Robert
 */
@Entity
@DiscriminatorValue("AGENCY")
public class TrainingAgency extends Training implements Serializable {

  private static final long serialVersionUID = -7216249524882960198L;

  @Column(length = 50)
  private String room;

  public TrainingAgency() {
    super(TrainingType.AGENCY);
  }

  public TrainingAgency(String name, String room, Date startDate) {
    super(TrainingType.AGENCY, name, startDate );
    this.room = room;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }
}
