package org.uva.sea.ql.parser.antlr.Tests.errorMsgTests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.Messages.ConditionError;

public class BoolConditionTest extends QL4ErrorTest {

	@BeforeClass
	public static void init() {
		setFile("test/conditionTest");
	}
	
	@Test
	public void testBoolConditionChecker() {
		// create literals
		Number one = new Number("1");
		Number five = new Number("5");
		Number ten =new Number("10");
		
		// create expressions
		Identifier ident1 = new Identifier("question");
		Identifier ident2 = new Identifier("question3");
		
		MinExpr minExpr = new MinExpr(one, ident2);
		MultExpr multExpr = new MultExpr(five, ten);
		
		BraceExpr brace1 = new BraceExpr(minExpr);
		BraceExpr brace2 = new BraceExpr(multExpr);
		// add errors
		expected.add(new ConditionError(ident1));
		expected.add(new ConditionError(brace1));
		expected.add(new ConditionError(brace2));
		
		// compare
		assertEquals(expected.get(0), errors.get(0));
		assertEquals(expected, errors);
	}
}
