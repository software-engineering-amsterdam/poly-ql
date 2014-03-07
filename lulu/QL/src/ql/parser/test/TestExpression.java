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
		assertEquals(new Integer(4), ((Int)parser.parseExpr("1+3").eval()).getValue());
		assertEquals(new Integer(5), ((Int)parser.parseExpr("1+3+1").eval()).getValue());
		assertEquals(new Integer(6), ((Int)parser.parseExpr("1+ (3+2)").eval()).getValue());
		assertEquals(new Integer(-2), ((Int)parser.parseExpr("1-3").eval()).getValue());
		assertEquals(new Integer(3), ((Int)parser.parseExpr("1+3-1").eval()).getValue());
		assertEquals(new Integer(5), ((Int)parser.parseExpr("10- (3+2)").eval()).getValue());
		assertEquals(new Integer(8), ((Int)parser.parseExpr("2*4").eval()).getValue());
		assertEquals(new Integer(12), ((Int)parser.parseExpr("2+5*2").eval()).getValue());
		assertEquals(new Integer(2), ((Int)parser.parseExpr("6 / 3").eval()).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("7-6/2").eval()).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("-1+5").eval()).getValue());
		assertEquals(new Integer(4), ((Int)parser.parseExpr("--4").eval()).getValue());
		assertEquals(new Integer(-4), ((Int)parser.parseExpr("+-4").eval()).getValue());
		assertEquals(new Integer(3), ((Int)parser.parseExpr("+4-1").eval()).getValue());
		assertEquals(new Integer(7), ((Int)parser.parseExpr("+4-(-3)").eval()).getValue());
	}
	
	@Test
	public void testTF() throws ParseError, IOException {
		assertTrue(((Bool)parser.parseExpr(" true && true").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("true && false").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("false && false").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("true || false").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("false || false").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("1==1").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("(1+2)==(0+3+0)").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("true==true").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("true==false").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("1==3").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("\"abc\"==\"bcd\"").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("\"abc\"==\"abc\"").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("\"abc\"!=\"abc\"").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("\"abc\"!=\"bld\"").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("1<3").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("1>3").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("1<=3").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("1>=3").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("(1<=3) || (4<2)").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("(1<=3)&&(9>4)").eval()).getValue());
		assertFalse(((Bool)parser.parseExpr("(!(1<=3)&&(9>4))").eval()).getValue());
		assertTrue(((Bool)parser.parseExpr("!(1>3)").eval()).getValue());
	}
}
