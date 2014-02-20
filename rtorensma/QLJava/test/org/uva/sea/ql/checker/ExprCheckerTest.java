package org.uva.sea.ql.checker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class ExprCheckerTest {
	
	private IParse parser = new ANTLRParser();

	@Test
	public void testExprChecker() throws ParseError {
		Expr ast;
		
		for (String binaryOperator : new String[]{"+", "-", "*", "/", "<", ">", "<=", ">="}) {
			ast = parser.parseExpr("1 " + binaryOperator + " 2");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
			ast = parser.parseExpr("1 " + binaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr("true " + binaryOperator + " 1");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
		}
		
		for (String unaryOperator : new String[]{"+", "-"}) {
			ast = parser.parseExpr(unaryOperator + " 2");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
			ast = parser.parseExpr(unaryOperator + " true");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr(unaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
		}
		
		for (String binaryOperator : new String[]{"==", "!=",}) {
			ast = parser.parseExpr("1 " + binaryOperator + " 2");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
			ast = parser.parseExpr("true " + binaryOperator + " false");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
//			TODO: add Idents to env and check expressions including those Idents..
//			ast = parser.parseExpr("Ident " + binaryOperator + " Ident");
//			ast = (ast.getClass().cast(ast));
//			assertTrue(checker.check(ast));
			
			ast = parser.parseExpr("1 " + binaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr("true " + binaryOperator + " 1");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr("true " + binaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
		}
		
		for (String binaryOperator : new String[]{"&&", "||"}) {
			ast = parser.parseExpr("true " + binaryOperator + " false");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
			ast = parser.parseExpr("1 " + binaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr("true " + binaryOperator + " 1");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr("Ident " + binaryOperator + " 1");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
		}
		
		for (String unaryOperator : new String[]{"!"}) {
			ast = parser.parseExpr(unaryOperator + " true");
			ast = (ast.getClass().cast(ast));
			assertTrue(ExprChecker.check(ast));
			
			ast = parser.parseExpr(unaryOperator + " 1");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
			
			ast = parser.parseExpr(unaryOperator + " Ident");
			ast = (ast.getClass().cast(ast));
			assertFalse(ExprChecker.check(ast));
		}
	}
}
