package fr.apside.formation;

import fr.apside.formation.test.JpaTest;
import org.junit.Test;

/**
 * @author François Robert
 */
public class ParticipationTest extends JpaTest {

  @Test
  public void participationPersonTrainingTest() {
    /*
    Person person = persist(new Person("login", "surname", "firstname"));
    TrainingOnline trainingOnline = persist(new TrainingOnline("onlineTraining", "url", new Date()));
    trainingOnline.setFormer(persist(new Person("formateur", "nom", "prenom")));
    Participation participation = new Participation(trainingOnline, person);
    persist(participation);
    Participation participationFinded = find(Participation.class, new ParticipationId(trainingOnline.getId(), person.getId()));
    assertNotNull(participationFinded);
    assertNotNull(participationFinded.getParticipant());
    assertNotNull(participationFinded.getTraining());
    Training training = find(Training.class, 1L);
    assertNotNull(training.getParticipationSet());
    Assert.assertEquals(0, training.getParticipationSet().size());
    getEntityManager().refresh(training); // pour forcer le rafraississment des relations
    */
  }

  @Test
  public void categorySettingTest() throws Exception {
    /*
    Training training = persist(new Training("training", new Date()));
    TrainingOnline trainingOnline = persist(new TrainingOnline("trainingOnline", "url", new Date(2016, 12, 1)));
    Category categoryToto = persist(new Category("toto"));
    Category categoryTata = persist(new Category("tata"));
    training.getCategorySet().add(categoryTata);
    training.getCategorySet().add(categoryToto);
    merge(training);
    trainingOnline.getCategorySet().add(categoryToto);
    merge(trainingOnline);
    assertNotNull(categoryTata.getTrainingSet());
    assertEquals(0, categoryTata.getTrainingSet().size());
    getEntityManager().refresh(categoryTata);
    assertEquals(1, categoryTata.getTrainingSet().size());
  */
  }

}
