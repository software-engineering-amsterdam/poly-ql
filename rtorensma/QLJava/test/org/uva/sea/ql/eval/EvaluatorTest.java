package org.uva.sea.ql.eval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.Not;

public class EvaluatorTest {
	private Evaluator evaluator = new Evaluator(new ValueEnvironment());

	@Test
	public void test() {
		Int intOne = new Int(1);
		Int intTwo = new Int(2);
		Add addExpr = new Add(intOne, intTwo);
		Value expected = new org.uva.sea.ql.eval.Int(3);
		
		Value actual = addExpr.accept(evaluator);
		assertEquals(expected, actual);
		
		Eq eqExpr = new Eq(intOne, intTwo);
		assertEquals(new org.uva.sea.ql.eval.Bool(false), eqExpr.accept(evaluator));
		
		eqExpr = new Eq(intOne, intOne);
		assertEquals(new org.uva.sea.ql.eval.Bool(true), eqExpr.accept(evaluator));
		
		
	}
	
	@Test
	public void testIdents() {
		Ident identOne = new Ident("1");
		Ident identTwo = new Ident("2");
		Ident identThree = new Ident("3");
		Ident identFour = new Ident("4");
		Add addExpr = new Add(identOne, identTwo);
		Eq eqExpr = new Eq(identOne, identTwo);
		And andExpr = new And(identThree, identFour);
		Not notExpr = new Not(identThree);
		
		org.uva.sea.ql.eval.Bool boolTrue = new org.uva.sea.ql.eval.Bool(true);
		org.uva.sea.ql.eval.Bool boolFalse = new org.uva.sea.ql.eval.Bool(false);
		
		ValueEnvironment valueEnv = this.evaluator.getValueEnv();
		valueEnv.setValueOfIdent(identOne, new org.uva.sea.ql.eval.Int(1));
		valueEnv.setValueOfIdent(identTwo, new org.uva.sea.ql.eval.Int(2));
		valueEnv.setValueOfIdent(identThree, new org.uva.sea.ql.eval.Bool(true));
		valueEnv.setValueOfIdent(identFour, new org.uva.sea.ql.eval.Bool(false));
		
		assertEquals(new org.uva.sea.ql.eval.Int(1), identOne.accept(evaluator));
		assertEquals(new org.uva.sea.ql.eval.Int(3), addExpr.accept(evaluator));
		assertEquals(boolFalse, eqExpr.accept(evaluator));
		eqExpr = new Eq(addExpr, addExpr);
		assertEquals(boolTrue, eqExpr.accept(evaluator));
		assertEquals(boolFalse, andExpr.accept(evaluator));
		andExpr = new And(identThree, identThree);
		assertEquals(boolTrue, andExpr.accept(evaluator));
		assertEquals(boolFalse, notExpr.accept(evaluator));
	}
}
