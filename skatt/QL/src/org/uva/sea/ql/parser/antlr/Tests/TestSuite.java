package org.uva.sea.ql.parser.antlr.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.antlr.Tests.sideTests.EqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.sideTests.TypeEqualityTest;

@RunWith(Suite.class)
@SuiteClasses({ plainTest.class,
				EqualityTest.class,
				BoolConditionTest.class,
				DuplicateLabelTest.class,
				DuplicateQuestionTest.class,
				CyclicDependencyTest.class,
				InvalidTypeTest.class,
				TypeEqualityTest.class,
				})
public class TestSuite {

}
