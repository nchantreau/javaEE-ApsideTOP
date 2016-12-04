package fr.apside.formation.model;

import fr.apside.formation.test.JpaTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author François Robert
 */
public class ParticipationTest extends JpaTest {

  @Test
  public void participationPersonTrainingTest() {
    Person person = persist(new Person("login", "surname", "firstname"));
    TrainingOnline trainingOnline = persist(new TrainingOnline("onlineTraining", "url", new Date()));
    trainingOnline.setFormer(persist(new Person("formateur", "nom", "prenom")));
    Participantion participantion = new Participantion(trainingOnline, person);
    persist(participantion);
    Participantion participantionFinded = find(Participantion.class, new ParticipationId(trainingOnline.getId(), person.getId()));
    assertNotNull(participantionFinded);
    assertNotNull(participantionFinded.getParticipant());
    assertNotNull(participantionFinded.getTraining());
    Training training = find(Training.class, 1L);
    assertNotNull(training.getParticipantionSet());
    Assert.assertEquals(0, training.getParticipantionSet().size());
    getEntityManager().refresh(training); // pour forcer le rafraississment des relations
  }

  @Test
  public void categorySettingTest() throws Exception {
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

  }

}
