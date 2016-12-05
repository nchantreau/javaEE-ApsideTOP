package fr.apside.formation;

import fr.apside.formation.model.Category;
import fr.apside.formation.model.Person;
import fr.apside.formation.model.Training;
import fr.apside.formation.model.TrainingAgency;
import fr.apside.formation.model.TrainingType;
import fr.apside.formation.services.BaseService;
import fr.apside.formation.services.PersonService;
import fr.apside.formation.test.EjbTest;
import org.junit.Test;

import javax.naming.NamingException;

import java.time.Period;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author François Robert
 */
public class ServicesTest extends EjbTest {

  @Test
  public void testBaseService() throws Exception {
    BaseService baseService = lookup(BaseService.class);
    assertNotNull(baseService);
    assertEquals("hello", baseService.sayHello());
  }

  @Test
  public void testPersonServiceCreate() throws Exception {
    PersonService personService = lookup(PersonService.class);
    assertNotNull(personService);
    Person person = personService.createPerson("ironMan", "Stark", "Anthony");
    assertNotNull(person);
    assertNotNull(person.getId());
    assertEquals(new Long(1L), person.getId());
  }

  @Test
  public void testPersonServiceFindAll() throws Exception {
    PersonService personService = lookup(PersonService.class);
    final int personMaxCount = 100;
    for (int idx = 0; idx < personMaxCount; idx++) {
      personService.createPerson("login" + String.format ("%03d", personMaxCount - idx), "surname_" + idx, "firstname-" + idx);
    }
    List<Person> personList = personService.findAll();
    assertNotNull(personList);
    assertTrue(personList.size() > 0);
    List<Person> paginatedPersonList = personService.findAll(2, 10);
    assertNotNull(paginatedPersonList);
    assertTrue(paginatedPersonList.size() == 10);
    Person person = paginatedPersonList.get(0);
    assertEquals(new Long(90L), person.getId());
    assertEquals("login011", person.getLogin());
  }

  @Test
  public void testPersonServiceFindByLoginAndMergeAndDelete() throws Exception {
    PersonService personService = lookup(PersonService.class);
    assertNotNull(personService);
    personService.createPerson("ironMan", "Stark", "Anthony");
    //---
    Person ironman = personService.findByLogin("ironMan");
    assertNotNull(ironman);
    assertEquals("Anthony", ironman.getFirstname());
    ironman.setFirstname(ironman.getFirstname() + " Junior");
    personService.merge(ironman);
    Person anthonyStarkJunior = personService.findById(1L);
    assertNotNull(anthonyStarkJunior);
    assertNotEquals("Anthony", ironman.getFirstname());
    assertEquals("Anthony Junior", ironman.getFirstname());
    Person deletedAnthonyStarkJunior = personService.delete(anthonyStarkJunior);
    assertNotNull(deletedAnthonyStarkJunior);
    assertNull(personService.findById(anthonyStarkJunior.getId()));
    Person deletedIronman = personService.delete(ironman);
    assertNull(deletedIronman);
  }

  @Test
  public void testTrainingService() throws Exception {
    /*
    Créer un service qui permet de gérer les formations (création, via enuméré est imposibilité de créer une formation de type UNKNOW)
    ATTENTION, le service ce gestion des Catégorie ne dot pas être le même
     */
    /*
    TrainingService trainingService = lookup(TrainingService.class);
    Training training = trainingService.createNewTraining(TrainingType.AGENCY, "Formation JavaEE", "java");
    assertNotNull(training);
    assertTrue(training instanceof TrainingAgency);
    assertNotNull(training.getId());
    assertTrue(training.getCategorySet().size() > 0);
    Category category = training.getCategorySet().stream().findFirst().orElse(null);
    assertNotNull(category);
    assertNotNull(category.getId());
    assertEquals(new Long(1L), category.getId());
    */
    // dans le même service créer une méthode permttant d'ajouter une autre catégorie (et de la créer si elle n'existe pas)
    // Implementer les tests afin de valider votre fonctionnement

    // Créer une formation OnLine
    // Implementer les tests afin de valider votre fonctionnement

    // créer une/des méthode(s) permettant de modifier et persister les modifications sur les formations (nom, catégoryn salle, url, etc...)
    // Implementer les tests afin de valider votre fonctionnement

  }


}
