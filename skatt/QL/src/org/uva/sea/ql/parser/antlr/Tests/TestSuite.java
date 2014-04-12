package org.uva.sea.ql.parser.antlr.Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateBinaryEqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateBinaryLogicalExprTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateBinaryMathExprTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateBinaryRelationTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateIdentifierTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluateUnaryExprTest;
import org.uva.sea.ql.parser.antlr.Tests.EvaluationTests.EvaluatedValuesTest;
import org.uva.sea.ql.parser.antlr.Tests.equalityTests.ErrorMsgEqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.equalityTests.ExpressionEqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.equalityTests.TypeEqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.equalityTests.ValueEqualityTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.BoolConditionTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.CyclicDependencyTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.DuplicateLabelTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.DuplicateQuestionTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.InvalidTypeTest;
import org.uva.sea.ql.parser.antlr.Tests.errorMsgTests.plainTest;

@RunWith(Suite.class)
@SuiteClasses({ plainTest.class,
				ErrorMsgEqualityTest.class,
				BoolConditionTest.class,
				DuplicateLabelTest.class,
				DuplicateQuestionTest.class,
				CyclicDependencyTest.class,
				InvalidTypeTest.class,
				TypeEqualityTest.class,
				ExpressionEqualityTest.class,
				EvaluatedValuesTest.class,
				ValueEqualityTest.class,
				EvaluateIdentifierTest.class,
				EvaluateUnaryExprTest.class,
				EvaluateBinaryLogicalExprTest.class,
				EvaluateBinaryMathExprTest.class,
				EvaluateBinaryRelationTest.class,
				EvaluateBinaryEqualityTest.class,
				})

public class TestSuite {

}
