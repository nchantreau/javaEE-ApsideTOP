package fr.apside.formation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author François Robert
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    PersonTest.class
    , TrainigTest.class
    , ParticipationTest.class
})
public class AllTest {
}
