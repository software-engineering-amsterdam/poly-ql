package org.uva.sea.ql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.evaluate.TestEvaluate;
import org.uva.sea.ql.parser.test.TestExpressions;
import org.uva.sea.ql.parser.test.TestForm;
import org.uva.sea.ql.parser.test.TestStatements;
import org.uva.sea.ql.parser.test.TestTypes;
import org.uva.sea.ql.typechecker.TestTypeChecker;

@RunWith(Suite.class)
@SuiteClasses({
		TestExpressions.class, 
        TestStatements.class, 
        TestTypes.class,
        TestForm.class,
        TestTypeChecker.class,
        TestEvaluate.class
		})

public class TestAllUnitTests {

}