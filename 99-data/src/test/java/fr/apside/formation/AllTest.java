package fr.apside.formation;

import fr.apside.formation.model.PersonTest;
import fr.apside.formation.model.TrainigTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author François Robert
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    PersonTest.class
    , TrainigTest.class
})
public class AllTest {
}
