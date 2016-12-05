package fr.apside.formation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author François Robert
 */
@Entity
@IdClass(ParticipationId.class)
public class Participation implements Serializable{

  private static final long serialVersionUID = 6082551497084979589L;
  public static final String FIND_PERSON_FOR_TRAINING = "Participation.FIND_PERSON_FOR_TRAINING";

  @Id
  @JoinColumn(name = "participation_training_id")
  private Long trainingId;

  @Id
  @JoinColumn(name = "participation_person_id")
  private Long participantId;

  @Temporal(TemporalType.DATE)
  private Date registration;

  public Participation() {
  }

  public Participation(Long trainingId, Long participantId) {
    this.trainingId = trainingId;
    this.participantId = participantId;
  }

  @PrePersist
  public void settingRegistrationDate() {
    setRegistration(new Date());
  }

  public Long getTrainingId() {
    return trainingId;
  }

  public void setTrainingId(Long trainingId) {
    this.trainingId = trainingId;
  }

  public Long getParticipantId() {
    return participantId;
  }

  public void setParticipantId(Long participantId) {
    this.participantId = participantId;
  }

  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }
}
