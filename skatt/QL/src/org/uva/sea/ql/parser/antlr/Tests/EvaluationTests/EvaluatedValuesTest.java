package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Tests evaluating values
 * @author Sammie Katt
 */
public class EvaluatedValuesTest extends QL4EvaluationTest {
	
	@Test
	public void testBool() {
		Bool falseBool = new Bool("false");
		Bool trueBool = new Bool("true");
		
		assertEquals(visitor.visit(falseBool), new Bool("false"));
		assertEquals(visitor.visit(trueBool), new Bool("true"));
		
		assertFalse(visitor.visit(trueBool).equals(new Bool("false")));
		assertFalse(visitor.visit(falseBool).equals(new Bool("true")));
	}
	
	@Test
	public void testNumber() {
		Number falseNumber = new Number("1");
		Number trueNumber = new Number("2");
		
		assertEquals(visitor.visit(falseNumber), new Number("1"));
		assertEquals(visitor.visit(trueNumber), new Number("2"));
		
		assertFalse(visitor.visit(trueNumber).equals(new Number("1")));
		assertFalse(visitor.visit(falseNumber).equals(new Number("2")));
	}
	
	@Test
	public void testText() {
		Text falseText = new Text("A string");
		Text trueText = new Text("Another string");
		
		assertEquals(visitor.visit(falseText), new Text("A string"));
		assertEquals(visitor.visit(trueText), new Text("Another string"));
		
		assertFalse(visitor.visit(trueText).equals(new Text("A string")));
		assertFalse(visitor.visit(falseText).equals(new Text("Another string")));
	}
	
	@Test
	public void testDecimal() {
		Decimal falseDecimal = new Decimal("1.1");
		Decimal trueDecimal = new Decimal("1.0");
		
		assertEquals(visitor.visit(falseDecimal), new Decimal("1.1"));
		assertEquals(visitor.visit(trueDecimal), new Decimal("1.0"));
		
		assertFalse(visitor.visit(trueDecimal).equals(new Decimal("1.1")));
		assertFalse(visitor.visit(falseDecimal).equals(new Decimal("1.0")));
	}
}
