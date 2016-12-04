package fr.apside.formation.model;

import java.io.Serializable;

/**
 * @author François Robert
 */
public class ParticipationId implements Serializable {

  private static final long serialVersionUID = 8358358735060081078L;

  private Long trainingId;

  private Long participantId;

  public ParticipationId() {
  }

  public ParticipationId(Long trainingId, Long participantId) {
    this.trainingId = trainingId;
    this.participantId = participantId;
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

  @Override
  public String toString() {
    return "ParticipationId{" +
        "trainingId=" + trainingId +
        ", participantId=" + participantId +
        '}';
  }
}
