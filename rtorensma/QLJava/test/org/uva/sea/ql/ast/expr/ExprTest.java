package org.uva.sea.ql.ast.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class ExprTest {

	private IParse parser = new ANTLRParser();

	@Test
	public void testAdds() throws ParseError {
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
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("a * b").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * b * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parser.parseExpr("a < b").getClass());
		assertEquals(LT.class, parser.parseExpr("a < b + c").getClass());
		assertEquals(LT.class, parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parseExpr("(a <= b)").getClass());
		assertEquals(GT.class, parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class, parser.parseExpr("a > b + c").getClass());
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(Not.class, parser.parseExpr("!b").getClass());
		assertEquals(And.class, parser.parseExpr("a && b").getClass());
		assertEquals(And.class, parser.parseExpr("a > b && b > c").getClass());
		assertEquals(And.class, parser.parseExpr("(a > b) && (b > c)").getClass());
		assertEquals(Bool.class, parser.parseExpr("true").getClass());
		assertEquals(Bool.class, parser.parseExpr("false").getClass());
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parseExpr("a").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parser.parseExpr("0").getClass());
		assertEquals(Int.class, parser.parseExpr("1223").getClass());
		assertEquals(Int.class, parser.parseExpr("234234234").getClass());
	}
	
	@Test
	public void testStrs() throws ParseError {
		assertEquals(Str.class, parser.parseExpr("\"Dit is een Str\"").getClass());
		assertEquals(Str.class, parser.parseExpr("\"\"").getClass());
	}
	
	@Test
	public void testComments() throws ParseError {
		assertEquals(Str.class, parser.parseExpr("// kdjksjdf \n \"Dit is eens Str\"").getClass());
		assertEquals(Str.class, parser.parseExpr("/* kdjksjdf */ \"Dit is eens Str\"").getClass());
		assertEquals(Bool.class, parser.parseExpr("// kdjksjdf \n true").getClass());
		assertEquals(Bool.class, parser.parseExpr("/* kdjksjdf */ false").getClass());
		assertEquals(Bool.class, parser.parseExpr("// kdjksjdf \n true // comment \n").getClass());
		assertEquals(Bool.class, parser.parseExpr("/* kdjksjdf */ false /* comment */").getClass());
	}
}