package test.nl.uva;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExpressionTest.class, ParserTest.class, ValidationTest.class })
public class AllTests {

}
