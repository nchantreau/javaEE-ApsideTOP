package fr.apside.formation.model;

import java.io.Serializable;
import java.util.Objects;

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

  public void setTrainingId(Long training) {
    this.trainingId = training;
  }

  public Long getParticipantId() {
    return participantId;
  }

  public void setParticipantId(Long participant) {
    this.participantId = participant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ParticipationId)) return false;
    ParticipationId that = (ParticipationId) o;
    return Objects.equals(getTrainingId(), that.getTrainingId()) &&
        Objects.equals(getParticipantId(), that.getParticipantId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTrainingId(), getParticipantId());
  }
}
