package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = Participation.FIND_PERSON_FOR_TRAINING
        , query = "select p.participant from Participation p where p.training.name = :" + Training.NAME
    )
})
public class Participation implements Serializable{

  private static final long serialVersionUID = 6082551497084979589L;
  public static final String FIND_PERSON_FOR_TRAINING = "Participation.FIND_PERSON_FOR_TRAINING";

  @Id
  @JoinColumn(name = "participation_training_id")
  private Training training;

  @Id
  @JoinColumn(name = "participation_person_id")
  private Person participant;

  @Temporal(TemporalType.DATE)
  private Date registration;

  public Participation() {
  }

  public Participation(Training training, Person participant) {
    this.training = training;
    this.participant = participant;
  }

  @PrePersist
  public void settingRegistrationDate() {
    setRegistration(new Date());
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

  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }
}
