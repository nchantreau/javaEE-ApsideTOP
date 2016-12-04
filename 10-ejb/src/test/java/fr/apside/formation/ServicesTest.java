package fr.apside.formation;

import fr.apside.formation.model.Person;
import fr.apside.formation.services.BaseService;
import fr.apside.formation.test.EjbTest;
import org.junit.Test;

import javax.naming.NamingException;

import java.time.Period;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
  public void testEntityManagerInjection() throws NamingException {
    BaseService baseService = lookup(BaseService.class);
    assertNotNull(baseService);
    List<Person> personList = baseService.getAllPerson();
  }
}
