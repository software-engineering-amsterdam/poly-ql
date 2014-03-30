package org.uva.sea.ql.parser.antlr.Tests.sideTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GreExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LesExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;

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
		
		exprDiff = new NeqExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testNeqExpr() {
		expr = new NeqExpr(idLeft, idRight);
		exprSame = new NeqExpr(idLeftSame, idRightSame);
		exprDiff = new NeqExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new EqExpr(idLeft, idRight);
		
		testEquality();
	}
	
	// logical expression tests
	@Test
	public void testAndExpr() {
		expr = new AndExpr(idLeft, idRight);
		exprSame = new AndExpr(idLeftSame, idRightSame);
		exprDiff = new AndExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new OrExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testOrExpr() {
		expr = new OrExpr(idLeft, idRight);
		exprSame = new OrExpr(idLeftSame, idRightSame);
		exprDiff = new OrExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new AndExpr(idLeft, idRight);
		
		testEquality();
	}
	
	// mathematical expression tests
	@Test
	public void testDivExpr() {
		expr = new DivExpr(idLeft, idRight);
		exprSame = new DivExpr(idLeftSame, idRightSame);
		exprDiff = new DivExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new MultExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testMinExpr() {
		expr = new MinExpr(idLeft, idRight);
		exprSame = new MinExpr(idLeftSame, idRightSame);
		exprDiff = new MinExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new PlusExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testMultExpr() {
		expr = new MultExpr(idLeft, idRight);
		exprSame = new MultExpr(idLeftSame, idRightSame);
		exprDiff = new MultExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new DivExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testPlusExpr() {
		expr = new PlusExpr(idLeft, idRight);
		exprSame = new PlusExpr(idLeftSame, idRightSame);
		exprDiff = new PlusExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new MinExpr(idLeft, idRight);
		
		testEquality();
	}
	
	// relational expression tests
	@Test
	public void testGreqExpr() {
		expr = new GeqExpr(idLeft, idRight);
		exprSame = new GeqExpr(idLeftSame, idRightSame);
		exprDiff = new GeqExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new GreExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testGreExpr() {
		expr = new GreExpr(idLeft, idRight);
		exprSame = new GreExpr(idLeftSame, idRightSame);
		exprDiff = new GreExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new GeqExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testLeqExpr() {
		expr = new LeqExpr(idLeft, idRight);
		exprSame = new LeqExpr(idLeftSame, idRightSame);
		exprDiff = new LeqExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new LesExpr(idLeft, idRight);
		
		testEquality();
	}
	
	@Test
	public void testLesExpr() {
		expr = new LesExpr(idLeft, idRight);
		exprSame = new LesExpr(idLeftSame, idRightSame);
		exprDiff = new LesExpr(idLeftDiff, idRightDiff);
		
		testEquality();
		
		exprDiff = new LeqExpr(idLeft, idRight);
		
		testEquality();
	}
	
	// unary expression equality tests 
	@Test 
	public void testBraceExpr() {
		expr = new BraceExpr(idLeft);
		exprSame = new BraceExpr(idLeftSame);
		exprDiff = new BraceExpr(idRight);
		
		testEquality();
		
		exprDiff = new NegExpr(idLeft);
	}
	
	@Test 
	public void testNegExpr() {
		expr = new NegExpr(idLeft);
		exprSame = new NegExpr(idLeftSame);
		exprDiff = new NegExpr(idRight);
		
		testEquality();
		
		exprDiff = new BraceExpr(idLeft);
	}
		
}
