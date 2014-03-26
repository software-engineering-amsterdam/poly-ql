package org.uva.sea.ql.checker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Str;

public class ExprCheckerTest {
	private final Int intOne = new Int(1);
	private final Int intTwo = new Int(2);
	private final Str strOne = new Str("one");
	private final Str strTwo = new Str("two");
	private final Bool boolTrue = new Bool(true);
	private final Bool boolFalse = new Bool(false);

	@Test
	public void testAdds() {
		Add addExpr = new Add(intOne, intTwo);
		assertTrue(ExprChecker.check(addExpr));
		
		addExpr = new Add(intOne, strOne);
		assertFalse(ExprChecker.check(addExpr));
		
		addExpr = new Add(intOne, boolTrue);
		assertFalse(ExprChecker.check(addExpr));
	}
	
	@Test
	public void testRels() {
		LT ltExpr = new LT(intOne, intTwo);
		assertTrue(ExprChecker.check(ltExpr));
		
		ltExpr = new LT(intOne, strTwo);
		assertFalse(ExprChecker.check(ltExpr));
		
		ltExpr = new LT(intOne, boolTrue);
		assertFalse(ExprChecker.check(ltExpr));
	}
	
	@Test
	public void testBools() {
		And andExpr = new And(boolTrue, boolFalse);
		assertTrue(ExprChecker.check(andExpr));
		
		andExpr = new And(boolTrue, strOne);
		assertFalse(ExprChecker.check(andExpr));
		
		andExpr = new And(boolTrue, intOne);
		assertFalse(ExprChecker.check(andExpr));
		
		Not notExpr = new Not(boolFalse);
		assertTrue(ExprChecker.check(notExpr));
	}
	
	@Test
	public void testIndents() {
		Ident identOne = new Ident("1");
		Ident identTwo = new Ident("2");
		Ident identThree = new Ident("3");
		
		TypeEnvironment typeEnv = new TypeEnvironment();
		typeEnv.setTypeOfIdent(identOne, new org.uva.sea.ql.ast.types.Int());
		typeEnv.setTypeOfIdent(identTwo, new org.uva.sea.ql.ast.types.Str());
		typeEnv.setTypeOfIdent(identThree, new org.uva.sea.ql.ast.types.Bool());
		
		assertTrue(ExprChecker.check(new Add(identOne, identOne), typeEnv, new ArrayList<String>()));
		assertFalse(ExprChecker.check(new Add(identOne, identTwo), typeEnv, new ArrayList<String>()));
		assertFalse(ExprChecker.check(new Add(identThree, identTwo), typeEnv, new ArrayList<String>()));
		
		assertTrue(ExprChecker.check(new And(identThree, identThree), typeEnv, new ArrayList<String>()));
		assertFalse(ExprChecker.check(new And(identOne, identThree), typeEnv, new ArrayList<String>()));
		
		assertTrue(ExprChecker.check(new LT(identOne, identOne), typeEnv, new ArrayList<String>()));
		assertFalse(ExprChecker.check(new LT(identThree, identThree), typeEnv, new ArrayList<String>()));
	}
}
