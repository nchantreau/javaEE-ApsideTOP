package fr.apside.formation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author François Robert
 */
@Entity
public class Person {

  @Id
  private Long id;

  private String login;

  private String surname;

  private String firstname;

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
