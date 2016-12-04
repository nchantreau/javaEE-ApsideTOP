package fr.apside.formation.model;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author François Robert
 */
@Entity
public class Participantion implements Serializable{

  private static final long serialVersionUID = 6082551497084979589L;

  private ParticipationId participationId;

  private Training training;

  private Person participant;

  public Participantion() {
  }

  public Participantion(Training training, Person participant) {
    setParticipationId(new ParticipationId(training.getId(), participant.getId()));
    this.training = training;
    this.participant = participant;
  }

  public ParticipationId getParticipationId() {
    return participationId;
  }

  public void setParticipationId(ParticipationId participationId) {
    this.participationId = participationId;
  }

  public Training getTraining() {
    return training;
  }

  public void setTraining(Training training) {
    this.training = training;
  }

  public Person getParticipant() {
    return participant;
  }

  public void setParticipant(Person participant) {
    this.participant = participant;
  }
}
