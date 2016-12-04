package fr.apside.formation.model;

import fr.apside.formation.test.JpaTest;
import org.junit.Test;

import static fr.apside.formation.model.TrainingType.UNKNOW;

/**
 * @author François Robert
 */
public class TrainigTest extends JpaTest {

  @Test
  public void simpleTest() {
    Training training = new Training(UNKNOW, "name");
    persist(training);
    Place place;
    persist(new TrainingSkill("name", "qualificationId", place = persist(new Place("place_name"))));
    persist(new TrainingSkill("name", "name", place));
    Person person = new Person("login", "surname", "firstname");
    person = persist(person);
    Address address = new Address("line", "zipcode", "city");
    address.setPerson(person);
    persist(address);
    training = new TrainingSkill("name", "name", place);
    training.setFormer(person);
    persist(training);
  }

}
