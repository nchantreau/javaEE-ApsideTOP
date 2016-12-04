package fr.apside.formation.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author François Robert
 */
public class ParticipationId implements Serializable {

  private static final long serialVersionUID = 8358358735060081078L;

  private Long training;

  private Long participant;

  public ParticipationId() {
  }

  public ParticipationId(Long trainingId, Long participantId) {
    this.training = trainingId;
    this.participant = participantId;
  }

  public Long getTraining() {
    return training;
  }

  public void setTraining(Long training) {
    this.training = training;
  }

  public Long getParticipant() {
    return participant;
  }

  public void setParticipant(Long participant) {
    this.participant = participant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ParticipationId)) return false;
    ParticipationId that = (ParticipationId) o;
    return Objects.equals(getTraining(), that.getTraining()) &&
        Objects.equals(getParticipant(), that.getParticipant());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTraining(), getParticipant());
  }
}
