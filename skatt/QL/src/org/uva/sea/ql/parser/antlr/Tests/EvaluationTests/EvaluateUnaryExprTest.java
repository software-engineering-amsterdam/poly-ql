package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;

public class EvaluateUnaryExprTest extends QL4EvaluationTest {

	@Test
	public void testBraceExpr() {
		Number num = new Number("1");
		BraceExpr braceExpr = new BraceExpr(num);
		
		assertEquals(visitor.visit(braceExpr), new Number("1"));
		assertFalse(visitor.visit(braceExpr).equals(new Number("2")));
	}
	
	@Test
	public void testNegExpr() {
		Bool bool = new Bool("true");
		NegExpr negExpr = new NegExpr(bool);
		
		assertEquals(visitor.visit(negExpr), new Bool("false"));
		assertFalse(visitor.visit(negExpr).equals(new Bool("true")));
	}
}
