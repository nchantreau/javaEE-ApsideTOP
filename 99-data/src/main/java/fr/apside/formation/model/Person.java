package fr.apside.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author François Robert
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

  private static final long serialVersionUID = 3457989253623908694L;

  /**
   * Identifiant
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id")
  private Long id;

  /**
   * Login
   */
  private String login;

  /**
   * Nom de famille
   */
  private String surname;

  /**
   * Prénom
   */
  @Column(name = "PERSON_FIRSTNAME")
  private String firstname;

  @OneToOne
  @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "address_person_id")
  private Address address;

  @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
  private Set<Participantion> trainingParticipationSet;
  /*
  private Set<Training> teachingTrainingSet;

  private Set<Participantion> participantionSet;
  */

  public Person() {
  }

  public Person(String login, String surname, String firstname) {
    this.login = login;
    this.surname = surname;
    this.firstname = firstname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return Objects.equals(getLogin(), person.getLogin());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLogin());
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", surname='" + surname + '\'' +
        ", firstname='" + firstname + '\'' +
        '}';
  }

}
