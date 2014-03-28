package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;

public class TestExpressions {

	private IParser<Expr> parser;

	public TestExpressions() {
		this.parser = new ExprParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a * b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testSubs() throws ParseError {
		assertEquals(parser.parse("a - b").getClass(), Sub.class);
		assertEquals(parser.parse("a - b - c").getClass(), Sub.class);
		assertEquals(parser.parse("(a - b - c)").getClass(), Sub.class);
		assertEquals(parser.parse("a - (b - c)").getClass(), Sub.class);
		assertEquals(parser.parse("(a - b) - c").getClass(), Sub.class);
		assertEquals(parser.parse("(a - b)").getClass(), Sub.class);
		assertEquals(parser.parse("a - b * c").getClass(), Sub.class);
		assertEquals(parser.parse("a * b - c").getClass(), Sub.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(parser.parse("a / b").getClass(), Div.class);
		assertEquals(parser.parse("a / b / c").getClass(), Div.class);
		assertEquals(parser.parse("a / (b / c)").getClass(), Div.class);
		assertEquals(parser.parse("(a / b) / c").getClass(), Div.class);
		assertEquals(parser.parse("(a / b)").getClass(), Div.class);
		assertEquals(parser.parse("(a + b) / c").getClass(), Div.class);
		assertEquals(parser.parse("a / (b + c)").getClass(), Div.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a + b < c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a > b").getClass(), GT.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
		assertEquals(parser.parse("a > (b * c)").getClass(), GT.class);
		assertEquals(parser.parse("(a * b) > c").getClass(), GT.class);
		assertEquals(parser.parse("a == b").getClass(), Eq.class);
		assertEquals(parser.parse("a == b + c").getClass(), Eq.class);
		assertEquals(parser.parse("a * b == c").getClass(), Eq.class);
		assertEquals(parser.parse("a == (b / c)").getClass(), Eq.class);
		assertEquals(parser.parse("a != b").getClass(), NEq.class);
		assertEquals(parser.parse("a != b + c").getClass(), NEq.class);
		assertEquals(parser.parse("a * b != c").getClass(), NEq.class);
		assertEquals(parser.parse("(a < b) != c)").getClass(), NEq.class);
	}

	@Test
	public void testAnd() throws ParseError {
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a && b > c").getClass(), And.class);
		assertEquals(parser.parse("a > b && c)").getClass(), And.class);
		assertEquals(parser.parse("(a || b) && c").getClass(), And.class);
		assertEquals(parser.parse("(a && b)").getClass(), And.class);
	}

	@Test
	public void testOr() throws ParseError {
		assertEquals(parser.parse("a || b").getClass(), Or.class);
		assertEquals(parser.parse("a || b > c").getClass(), Or.class);
		assertEquals(parser.parse("a > b || c").getClass(), Or.class);
		assertEquals(parser.parse("a || (b && c)").getClass(), Or.class);
	}

	@Test
	public void testPos() throws ParseError {
		assertEquals(parser.parse("+ a").getClass(), Pos.class);
		assertEquals(parser.parse("+ - a").getClass(), Pos.class);
		assertEquals(parser.parse("+ + a").getClass(), Pos.class);
		assertEquals(parser.parse("+ (a - b) ").getClass(), Pos.class);
	}

	@Test
	public void TestNeg() throws ParseError {
		assertEquals(parser.parse("- a").getClass(), Neg.class);
		assertEquals(parser.parse("- - a").getClass(), Neg.class);
		assertEquals(parser.parse("- + a").getClass(), Neg.class);
		assertEquals(parser.parse("- (a + b) ").getClass(), Neg.class);
	}

	@Test
	public void testNot() throws ParseError {
		assertEquals(parser.parse("! a").getClass(), Not.class);
		assertEquals(parser.parse("!(a && b)").getClass(), Not.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("aBC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abC2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("_a2bc232aa").getClass(), Ident.class);
		assertEquals(parser.parse("_2abc232aa").getClass(), Ident.class);
	}

	@Test
	public void testBool() throws ParseError {
		assertEquals(parser.parse("true").getClass(), BoolLiteral.class);
		assertEquals(parser.parse("false").getClass(), BoolLiteral.class);
	}
	
	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), IntLiteral.class);
		assertEquals(parser.parse("1223").getClass(), IntLiteral.class);
		assertEquals(parser.parse("234234234").getClass(), IntLiteral.class);
	}
	
	@Test
	public void testString() throws ParseError {
		assertEquals(parser.parse("\"\"").getClass(), StrLiteral.class);
		assertEquals(parser.parse("\"\\\"\n\r\t\f\"").getClass(), StrLiteral.class);
		assertEquals(parser.parse("\"~`!@#$%^&*()_-+={}|[]:;'<>?,./\"").getClass(), StrLiteral.class);
		assertEquals(parser.parse("\"the quick brown fox jumps over the lazy dog\"").getClass(), StrLiteral.class);
		assertEquals(parser.parse("\"THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG\"").getClass(), StrLiteral.class);
	}
	
}
