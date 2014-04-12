package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GreExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LesExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Tests the evaluator visitor on binary mathematical expressions (including throwing exceptions)
 * @author Sammie Katt
 */
public class EvaluateBinaryRelationTest extends QL4EvaluationTest {

	Number one; 
	Decimal two;
	Bool trueBool;
	Text string;
	
	@Before
	public void init() {
		one = new Number("1");
		two = new Decimal("2");
		
		trueBool = new Bool("true");
		string  = new Text("hoi");
	}

	@Test (expected=UnsupportedOperationException.class)
	public void testThrowing() {
		GreExpr gre1 = new GreExpr(trueBool, one);
		GreExpr gre2 = new GreExpr(two, string);
		
		LesExpr les1 = new LesExpr(trueBool, one);
		LesExpr les2 = new LesExpr(two, string);
		
		LeqExpr leq1 = new LeqExpr(trueBool, one);
		LeqExpr leq2 = new LeqExpr(two, string);
		
		GeqExpr geqt1 = new GeqExpr(trueBool, one);
		GeqExpr geqt2 = new GeqExpr(two, string);
		
		visitor.visit(gre1);
		visitor.visit(gre2);
		
		visitor.visit(les1);
		visitor.visit(les2);
		
		visitor.visit(leq1);
		visitor.visit(leq2);
		
		visitor.visit(geqt1);
		visitor.visit(geqt2);
		
	}
	
	@Test
	public void testGre() {
		GreExpr gre1 = new GreExpr(one, two);
		GreExpr gre2 = new GreExpr(two, one);
		GreExpr gre3 = new GreExpr(one, one);
		
		assertEquals(visitor.visit(gre1), new Bool("false"));
		assertEquals(visitor.visit(gre2), new Bool("true"));
		assertEquals(visitor.visit(gre3), new Bool("false"));
	}
	
	@Test
	public void testLes() {
		LesExpr les1 = new LesExpr(one, two);
		LesExpr les2 = new LesExpr(two, one);
		LesExpr les3 = new LesExpr(one, one);
		
		assertEquals(visitor.visit(les1), new Bool("true"));
		assertEquals(visitor.visit(les2), new Bool("false"));
		assertEquals(visitor.visit(les3), new Bool("false"));
	}
	
	@Test
	public void testLeq() {
		LeqExpr leq1 = new LeqExpr(one, two);
		LeqExpr leq2 = new LeqExpr(two, one);
		LeqExpr leq3 = new LeqExpr(one, one);
		
		assertEquals(visitor.visit(leq1), new Bool("true"));
		assertEquals(visitor.visit(leq2), new Bool("false"));
		assertEquals(visitor.visit(leq3), new Bool("true"));
	}
	
	@Test
	public void testGeq() {
		GeqExpr geq1 = new GeqExpr(one, two);
		GeqExpr geq2 = new GeqExpr(two, one);
		GeqExpr geq3 = new GeqExpr(one, one);
		
		assertEquals(visitor.visit(geq1), new Bool("false"));
		assertEquals(visitor.visit(geq2), new Bool("true"));
		assertEquals(visitor.visit(geq3), new Bool("true"));
	}
}
