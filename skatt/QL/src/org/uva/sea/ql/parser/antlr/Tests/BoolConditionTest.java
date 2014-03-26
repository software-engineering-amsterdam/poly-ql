package org.uva.sea.ql.parser.antlr.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.ConditionError;

public class BoolConditionTest extends QL4Test {

	@BeforeClass
	public static void init() {
		setFile("test/conditionTest");
	}
	
	@Test
	public void testBoolConditionChecker() {
		Expression expr = new Identifier("question");
		expected.add(new ConditionError(expr));
		assertEquals(expected.get(0), errors.get(0));
		assertEquals(expected, errors);
	}
}
