package ql.tests;

import java.util.HashMap;
import junit.framework.Assert;

import org.junit.Test;

import ql.ast.interpreter.*;
import ql.ast.node.*;
import ql.ast.node.arithmetic.Add;
import ql.ast.node.arithmetic.Div;
import ql.ast.node.arithmetic.Mul;
import ql.ast.node.arithmetic.Sub;
import ql.ast.node.conditional.*;
import ql.ast.node.literals.*;
import ql.ast.node.relational.Eq;
import ql.ast.node.relational.GEq;
import ql.ast.node.relational.GT;
import ql.ast.node.relational.LEq;
import ql.ast.node.relational.LT;
import ql.ast.node.relational.NEq;
import ql.ast.node.sign.Neg;
import ql.ast.node.sign.Not;
import ql.ast.node.sign.Pos;
import ql.questionaire.model.answer.Answer;

public class ValuesComputer {

	private void compute(Expression e, Literal expected) {
		Literal actual = ValueComputer.compute(e, new HashMap<String,Answer>());
		Assert.assertEquals(expected, actual);
	}

	@Test	
	public void compute_expressionWithoutIdentifiers() {		
		this.compute(new And(new Bool(true), new Bool(true)),  new Bool(true));
		this.compute(new Or(new Bool(false), new Bool(true)),  new Bool(true));
		this.compute(new Add(new Int(6), new Int(2)),  	new Int(8));
		this.compute(new Sub(new Int(6), new Int(2)), 	new Int(4));
		this.compute(new Div(new Int(6), new Int(2)), 	new Int(3));
		this.compute(new Mul(new Int(6), new Int(2)), 	new Int(12));
		this.compute(new Eq(new Int(6), new Int(6)), 	new Bool(true));
		this.compute(new NEq(new Int(6), new Int(5)),	new Bool(true));
		this.compute(new LEq(new Int(6), new Int(6)),	new Bool(true));
		this.compute(new LT(new Int(5), new Int(6)), 	new Bool(true));
		this.compute(new GEq(new Int(6), new Int(6)), 	new Bool(true));
		this.compute(new GT(new Int(7), new Int(6)), 	new Bool(true));
		this.compute(new Not(new Bool(false)), 			new Bool(true));
		this.compute(new Neg(new Int(5)), 				new Int(-5));		
		this.compute(new Pos(new Int(5)), 				new Int(5));
		this.compute(new Eq(new Str("hel"),new Str("hel")), new Bool(true));
	}

}
