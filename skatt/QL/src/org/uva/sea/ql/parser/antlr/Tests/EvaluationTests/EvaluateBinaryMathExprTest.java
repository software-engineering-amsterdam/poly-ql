package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Tests the evaluator visitor on binary mathematical expressions (including throwing exceptions)
 * @author Sammie Katt
 */
public class EvaluateBinaryMathExprTest extends QL4EvaluationTest {

	Number one, two;
	Bool trueBool;
	Text string;
	
	@Before
	public void init() {
		one = new Number("1");
		two = new Number("2");
		
		trueBool = new Bool("true");
		string  = new Text("hoi");
	}

	@Test (expected=UnsupportedOperationException.class)
	public void testThrowing() {
		PlusExpr plus1 = new PlusExpr(trueBool, one);
		PlusExpr plus2 = new PlusExpr(two, string);
		
		MinExpr min1 = new MinExpr(trueBool, one);
		MinExpr min2 = new MinExpr(two, string);
		
		DivExpr div1 = new DivExpr(trueBool, one);
		DivExpr div2 = new DivExpr(two, string);
		
		MultExpr mult1 = new MultExpr(trueBool, one);
		MultExpr mult2 = new MultExpr(two, string);
		
		visitor.visit(plus1);
		visitor.visit(plus2);
		
		visitor.visit(min1);
		visitor.visit(min2);
		
		visitor.visit(div1);
		visitor.visit(div2);
		
		visitor.visit(mult1);
		visitor.visit(mult2);
		
	}
	
	@Test
	public void testPlus() {
		PlusExpr plus1 = new PlusExpr(one, two);
		PlusExpr plus2 = new PlusExpr(two, one);
		
		assertEquals(visitor.visit(plus1), new Number("3"));
		assertFalse(visitor.visit(plus1).equals(new Number("2")));
		assertEquals(visitor.visit(plus2), new Number("3"));
		assertFalse(visitor.visit(plus2).equals(new Number("2")));
	}
	
	@Test
	public void testMin() {
		MinExpr min1 = new MinExpr(one, two);
		MinExpr min2 = new MinExpr(two, one);
		
		assertEquals(visitor.visit(min1), new Number("-1"));
		assertFalse(visitor.visit(min1).equals(new Number("2")));
		assertEquals(visitor.visit(min2), new Number("1"));
		assertFalse(visitor.visit(min2).equals(new Number("2")));
	}
	
	@Test
	public void testDiv() {
		DivExpr div1 = new DivExpr(one, two);
		DivExpr div2 = new DivExpr(two, one);
		
		assertEquals(visitor.visit(div1), new Decimal("0.5"));
		assertFalse(visitor.visit(div1).equals(new Decimal("2")));
		assertEquals(visitor.visit(div2), new Decimal("2"));
		assertFalse(visitor.visit(div2).equals(new Decimal("1")));
	}
	
	@Test
	public void testMult() {
		MultExpr mult1 = new MultExpr(one, two);
		MultExpr mult2 = new MultExpr(two, one);
		
		assertEquals(visitor.visit(mult1), new Number("2"));
		assertFalse(visitor.visit(mult1).equals(new Number("1")));
		assertEquals(visitor.visit(mult2), new Number("2"));
		assertFalse(visitor.visit(mult2).equals(new Number("3")));
	}
}
