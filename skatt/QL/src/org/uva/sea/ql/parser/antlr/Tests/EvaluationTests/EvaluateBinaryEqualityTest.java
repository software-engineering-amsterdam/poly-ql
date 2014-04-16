package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Tests the evaluator visitor on equality evaluations
 * @author Sammie Katt
 */
public class EvaluateBinaryEqualityTest extends QL4EvaluationTest {

	Number num1, num2;
	Decimal dec1, dec2;
	Text string1, string2;
	Bool bool1, bool2;
	
	@Before
	public void init() {
		num1 = new Number("1");
		num2 = new Number("2");
		
		dec1 = new Decimal("1.2");
		dec2 = new Decimal("1.3");
		
		string1 = new Text("bye");
		string2 = new Text("hi");
		
		bool1 = new Bool("true");
		bool2 = new Bool("false");
	}
	
	@Test
	public void testEqTrue() {
		EqExpr eq1 = new EqExpr(num1, num1);
		EqExpr eq2 = new EqExpr(dec1, dec1);
		EqExpr eq3 = new EqExpr(bool1, bool1);
		EqExpr eq4 = new EqExpr(string1, string1);
		
		assertEquals(new Bool("true"), visitor.visit(eq1));
		assertEquals(new Bool("true"), visitor.visit(eq2));
		assertEquals(new Bool("true"), visitor.visit(eq3));
		assertEquals(new Bool("true"), visitor.visit(eq4));
	}
	
	@Test
	public void testNeqTrue() {
		NeqExpr eq1 = new NeqExpr(num1, num1);
		NeqExpr eq2 = new NeqExpr(dec1, dec1);
		NeqExpr eq3 = new NeqExpr(bool1, bool1);
		NeqExpr eq4 = new NeqExpr(string1, string1);
		
		assertFalse(new Bool("true").equals(visitor.visit(eq1)));
		assertFalse(new Bool("true").equals(visitor.visit(eq2)));
		assertFalse(new Bool("true").equals(visitor.visit(eq3)));
		assertFalse(new Bool("true").equals(visitor.visit(eq4)));
	}
	
	@Test
	public void testEqFalse() {
		EqExpr eq1 = new EqExpr(num1, dec1);
		EqExpr eq2 = new EqExpr(dec1, bool1);
		EqExpr eq3 = new EqExpr(bool1, string1);
		EqExpr eq4 = new EqExpr(string1, num1);
		EqExpr eq5 = new EqExpr(num1, num2);
		
		assertFalse(new Bool("true").equals(visitor.visit(eq1)));
		assertFalse(new Bool("true").equals(visitor.visit(eq2)));
		assertFalse(new Bool("true").equals(visitor.visit(eq3)));
		assertFalse(new Bool("true").equals(visitor.visit(eq4)));
		assertFalse(new Bool("true").equals(visitor.visit(eq5)));
	}
	
	@Test
	public void testNeqFalse() {
		NeqExpr eq1 = new NeqExpr(num1, dec1);
		NeqExpr eq2 = new NeqExpr(dec1, bool1);
		NeqExpr eq3 = new NeqExpr(bool1, string1);
		NeqExpr eq4 = new NeqExpr(string1, num1);
		NeqExpr eq5 = new NeqExpr(num1, num2);
		
		assertEquals(new Bool("true"), visitor.visit(eq1));
		assertEquals(new Bool("true"), visitor.visit(eq2));
		assertEquals(new Bool("true"), visitor.visit(eq3));
		assertEquals(new Bool("true"), visitor.visit(eq4));
		assertEquals(new Bool("true"), visitor.visit(eq5));
	}
}
