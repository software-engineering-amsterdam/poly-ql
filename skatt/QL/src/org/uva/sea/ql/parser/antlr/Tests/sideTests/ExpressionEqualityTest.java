package org.uva.sea.ql.parser.antlr.Tests.sideTests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.EqExpr;

/**
 * Performs equality tests on expressions in QL4
 * @author Sammie Katt
 */
public class ExpressionEqualityTest {

	// all the expression / identifiers used in the tests
	Expression expr;
	Expression exprDiff;
	Expression exprSame;
	
	Identifier idLeft;
	Identifier idLeftDiff;
	Identifier idLeftSame;
	
	Identifier idRight;
	Identifier idRightDiff;
	Identifier idRightSame;
	
	@Before
	public void setUp() {
		idLeft = new Identifier("IDLeft");
		idRight = new Identifier("IDRight");
		
		idLeftDiff = new Identifier("IDLeft diff");
		idRightDiff = new Identifier("IDRight diff");
		
		idLeftSame = new Identifier("IDLeft");
		idRightSame = new Identifier("IDRight");
	}
	
	/**
	 * Called after all tests: the tests initialize the variables and here they are tested
	 */
	public void testEquality() {
		assertEquals(expr, exprSame);
		assertFalse(expr.equals(exprDiff));
	}
	
	// equality expression tests
	@Test
	public void testEqExpr() {
		expr = new EqExpr(idLeft, idRight);
		exprSame = new EqExpr(idLeftSame, idRightSame);
		exprDiff = new EqExpr(idLeftDiff, idRightDiff);
		
		testEquality();
	}
}
