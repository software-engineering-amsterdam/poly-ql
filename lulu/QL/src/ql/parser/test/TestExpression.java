package ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ql.ast.expr.exprType.Ident;
import ql.ast.expr.exprType.IntExpr;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;
import ql.ast.value.Bool;
import ql.ast.value.Int;
import ql.parser.antlr.FormParser;

public class TestExpression {
	FormParser parser = new FormParser();
	
	@Test
	public void testAdd() throws ParseError, IOException {
		assertEquals(Add.class, parser.parseExpr("a + b").getClass());
		assertEquals(Add.class, parser.parseExpr("a + b + c").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parseExpr("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b)").getClass());
		assertEquals(Add.class, parser.parseExpr("a + b * c").getClass());
		assertEquals(Add.class, parser.parseExpr("a * b + c").getClass());
	}
	
	@Test
	public void testMul() throws ParseError, IOException {
		assertEquals(Mul.class, parser.parseExpr("a * b").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * b * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b + c)").getClass());
	}
	
	@Test
	public void testDiv() throws ParseError, IOException {
		assertEquals(Div.class, parser.parseExpr("a / b").getClass());
		assertEquals(Div.class, parser.parseExpr("a * b / c").getClass());
		assertEquals(Div.class, parser.parseExpr("a / (b * c)").getClass());
		assertEquals(Div.class, parser.parseExpr("(a * b) / c").getClass());
		assertEquals(Div.class, parser.parseExpr("(a / b)").getClass());
		assertEquals(Div.class, parser.parseExpr("(a + b) / c").getClass());
		assertEquals(Div.class, parser.parseExpr("a / (b + c)").getClass());
	}
	@Test
	public void testRel() throws ParseError, IOException {
		assertEquals(LT.class, parser.parseExpr("a < b").getClass());
		assertEquals(LT.class, parser.parseExpr("a < b + c").getClass());
		assertEquals(LT.class, parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parseExpr("(a <= b)").getClass());
		assertEquals(GT.class, parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class, parser.parseExpr("a > b + c").getClass());
	}


	@Test
	public void testId() throws ParseError, IOException {
		assertEquals(Ident.class, parser.parseExpr("a").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testInt() throws ParseError, IOException {
		assertEquals(IntExpr.class, parser.parseExpr("0").getClass());
		assertEquals(IntExpr.class, parser.parseExpr("1223").getClass());
		assertEquals(IntExpr.class, parser.parseExpr("234234234").getClass());
	}
	
	@Test
	public void testCalculate() throws ParseError, IOException {
		assertEquals(new Integer(4), ((Int)parser.parseExpr("1+3").eval(null)).getValue());
		assertEquals(new Integer(5), ((Int)parser.parseExpr("1+3+1").eval(null)).getValue());
		assertEquals(new Integer(6), ((Int)parser.parseExpr("1+ (3+2)").eval(null)).getValue());
		assertEquals(new Integer(-2), ((Int)parser.parseExpr("1-3").eval(null)).getValue());
		assertEquals(new Integer(3), ((Int)parser.parseExpr("1+3-1").eval(null)).getValue());
		assertEquals(new Integer(5), ((Int)parser.parseExpr("10- (3+2)").eval(null)).getValue());
		assertEquals(new Integer(8), ((Int)parser.parseExpr("2*4").eval(null)).getValue());
		assertEquals(new Integer(12), ((Int)parser.parseExpr("2+5*2").eval(null)).getValue());
		assertEquals(new Integer(2), ((Int)parser.parseExpr("6 / 3").eval(null)).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("7-6/2").eval(null)).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("-1+5").eval(null)).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("--4").eval(null)).getValue());
		assertEquals(new Integer(-4), ((Int)parser.parseExpr("+-4").eval(null)).getValue());
		assertEquals(new Integer(3), ((Int)parser.parseExpr("+4-1").eval(null)).getValue());
		assertEquals(new Integer(7), ((Int)parser.parseExpr("+4-(-3)").eval(null)).getValue());
	}
	
	@Test
	public void testTF() throws ParseError, IOException {
		assertTrue(((Bool)parser.parseExpr(" true && true").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("true && false").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("false && false").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("true || false").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("false || false").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("1==1").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("(1+2)==(0+3+0)").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("true==true").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("true==false").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("1==3").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("\"abc\"==\"bcd\"").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("\"abc\"==\"abc\"").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("\"abc\"!=\"abc\"").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("\"abc\"!=\"bld\"").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("1<3").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("1>3").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("1<=3").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("1>=3").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("(1<=3) || (4<2)").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("(1<=3)&&(9>4)").eval(null)).getValue());
		assertFalse(((Bool)parser.parseExpr("(!(1<=3)&&(9>4))").eval(null)).getValue());
		assertTrue(((Bool)parser.parseExpr("!(1>3)").eval(null)).getValue());
	}
	
	@Test
	public void testTypeChecking() throws ParseError, IOException {
		//Binary check
		assertEquals(0, parser.parseExpr("1 + 5").checkType(null).size());
		assertEquals(1, parser.parseExpr("true + 5").checkType(null).size());
		assertEquals(2, parser.parseExpr("true + true").checkType(null).size());
		assertEquals(2, parser.parseExpr("true * (false-4)").checkType(null).size());
		assertEquals(2, parser.parseExpr("true || (false-4)").checkType(null).size());
		
		assertEquals("+: Left expression is not a integer", parser.parseExpr("true + 5").checkType(null).get(0).getText());
		assertEquals("+: Right expression is not a integer", parser.parseExpr("true + true").checkType(null).get(1).getText());	
		assertEquals("-: Left expression is not a integer", parser.parseExpr("true || (false-4)").checkType(null).get(0).getText());
		assertEquals("&&: Left expression is not a boolean", parser.parseExpr("21 && (false-(4!=true))").checkType(null).get(3).getText());

		//Unary check
		assertEquals(1, parser.parseExpr("!5").checkType(null).size());
		assertEquals(0, parser.parseExpr("!(3==2)").checkType(null).size());
		assertEquals(1, parser.parseExpr("-true").checkType(null).size());
		assertEquals(1, parser.parseExpr("!\"this is a string\"").checkType(null).size());
		assertEquals(0,parser.parseExpr("\"t\" != \"s\"").checkType(null).size());
		
		assertEquals("+: Expression is not a integer", parser.parseExpr("+false").checkType(null).get(0).getText());
		assertEquals("!: Expression is not a boolean", parser.parseExpr("!3").checkType(null).get(0).getText());	
		assertEquals("!: Expression is not a boolean", parser.parseExpr("!(-3)").checkType(null).get(0).getText());
		assertEquals("&&: Left expression is not a boolean", parser.parseExpr("21 && (false-(4!=true))").checkType(null).get(3).getText());
		assertEquals("<=: Left expression is not a integer", parser.parseExpr("\"a\" <= \"b\"").checkType(null).get(0).getText());
	}
}
