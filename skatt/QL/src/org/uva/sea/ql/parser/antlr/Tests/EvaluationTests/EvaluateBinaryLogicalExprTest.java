package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Tests the evaluator visitor on binary logical expressions
 * @author Sammie Katt
 */
public class EvaluateBinaryLogicalExprTest extends QL4EvaluationTest {

	Bool falseBool, trueBool;
	Number num;
	Text string;
	@Before
	public void init() {
		falseBool = new Bool("false");
		trueBool = new Bool("true");
		
		num = new Number("2");
		string = new Text("hoi");
	}
	
	
	@Test (expected=UnsupportedOperationException.class)
	public void testThrowing() {
		OrExpr or1 = new OrExpr(trueBool, num);
		OrExpr or2 = new OrExpr(falseBool, string);
		
		AndExpr and1 = new AndExpr(num, trueBool);
		AndExpr and2 = new AndExpr(falseBool, string);
		
		visitor.visit(or1);
		visitor.visit(or2);
		
		visitor.visit(and1);
		visitor.visit(and2);
	}
	
	@Test
	public void testOr() {
		OrExpr or1 = new OrExpr(trueBool, falseBool);
		OrExpr or2 = new OrExpr(trueBool, trueBool);
		OrExpr or3 = new OrExpr(falseBool, falseBool);
		
		assertEquals(visitor.visit(or1), new Bool("true"));
		assertEquals(visitor.visit(or2), new Bool("true"));
		assertEquals(visitor.visit(or3), new Bool("false"));
		
		assertFalse(visitor.visit(or1).equals(new Bool("false")));
		assertFalse(visitor.visit(or2).equals(new Bool("false")));
		assertFalse(visitor.visit(or3).equals(new Bool("true")));
	}
	
	@Test
	public void testAnd() {
		AndExpr and1 = new AndExpr(trueBool, falseBool);
		AndExpr and2 = new AndExpr(falseBool, falseBool);
		AndExpr and3 = new AndExpr(trueBool, trueBool);
		
		assertEquals(visitor.visit(and1), new Bool("false"));
		assertEquals(visitor.visit(and2), new Bool("false"));
		assertEquals(visitor.visit(and3), new Bool("true"));
		
		assertFalse(visitor.visit(and1).equals(new Bool("true")));
		assertFalse(visitor.visit(and2).equals(new Bool("true")));
		assertFalse(visitor.visit(and3).equals(new Bool("false")));
	}

}
