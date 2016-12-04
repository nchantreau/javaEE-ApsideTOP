package fr.apside.formation.model;

import fr.apside.formation.test.JpaTest;
import org.junit.Test;

import java.util.Date;

import static fr.apside.formation.model.TrainingType.UNKNOW;

/**
 * @author François Robert
 */
public class TrainigTest extends JpaTest {

  @Test
  public void simpleTest() {
    Training training = new Training(UNKNOW, "name", new Date());
    persist(training);
    persist(new TrainingAgency("name", "room",new Date()));
    persist(new TrainingAgency("name", "room", new Date()));
    Person person = new Person("login", "surname", "firstname");
    person = persist(person);
    Address address = new Address("line", "zipcode", "city");
    address.setPerson(person);
    persist(address);
    training = new TrainingAgency("name", "room", new Date());
    training.setFormer(person);
    persist(training);
  }

}
