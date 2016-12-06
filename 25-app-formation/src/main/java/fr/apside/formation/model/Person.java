package fr.apside.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author François Robert
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Person.FIND_ALL_ORDER_BY_LOGIN
        , query = "select p from Person p order by p.login"
    ),
    @NamedQuery(name = Person.FIND_BY_LOGIN
        , query = "select p from Person p where p.login = :" + Person.LOGIN
    )
})
public class Person implements Serializable {

  private static final long serialVersionUID = 3457989253623908694L;
  public static final String FIND_ALL_ORDER_BY_LOGIN = "Person.FIND_ALL_ORDER_BY_LOGIN";
  public static final String FIND_BY_LOGIN = "Person.FIND_BY_LOGIN";
  public static final String LOGIN = "personLogin";
  public static final String FIND_FOR_TRAINING = "Person.FIND_FOR_TRAINING";

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
  private String firstname;

  @OneToOne
  @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "address_person_id")
  private Address address;

  @OneToMany(mappedBy = "participantId", fetch = FetchType.LAZY)
  private Set<Participation> trainingParticipationSet;

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

  public Set<Participation> getTrainingParticipationSet() {
    return trainingParticipationSet;
  }

  public void setTrainingParticipationSet(Set<Participation> trainingParticipationSet) {
    this.trainingParticipationSet = trainingParticipationSet;
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
