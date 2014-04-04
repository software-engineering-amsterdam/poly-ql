package ql.ast.node.literals;

import ql.ast.interpreter.LiteralWithoutValue;
import ql.ast.node.Expression;

public abstract class Literal extends Expression {

	public boolean isBoolean() {
		return false;
	}

	public Boolean getValueIfBoolean() { 
		return null;
	}

	public boolean hasValue() {
		return false;
	}

	private Literal impossibleOp() {
		assert false;
		return new LiteralWithoutValue();
	}

	public Literal add(Literal literal) 	{ return impossibleOp(); }
	public Literal add(int value) 			{ return impossibleOp(); }
	public Literal div(Literal operand) 	{ return impossibleOp(); }
	public Literal div(int value) 			{ return impossibleOp(); }
	public Literal mul(Literal operand) 	{ return impossibleOp(); }
	public Literal mul(int value) 			{ return impossibleOp(); }
	public Literal sub(Literal operand) 	{ return impossibleOp(); }
	public Literal sub(int value) 			{ return impossibleOp(); }
	public Literal eq(Literal operand) 		{ return impossibleOp(); }
	public Literal eq(boolean value) 		{ return impossibleOp(); }
	public Literal eq(int value) 			{ return impossibleOp(); }
	public Literal geq(Literal operand) 	{ return impossibleOp(); }
	public Literal geq(int value) 			{ return impossibleOp(); }
	public Literal gt(Literal operand) 		{ return impossibleOp(); }
	public Literal gt(int value) 			{ return impossibleOp(); }
	public Literal leq(Literal operand) 	{ return impossibleOp(); }
	public Literal leq(int value) 			{ return impossibleOp(); }
	public Literal lt(Literal operand) 		{ return impossibleOp(); }
	public Literal lt(int value) 			{ return impossibleOp(); }
	public Literal neq(Literal operand) 	{ return impossibleOp(); }
	public Literal neq(boolean value) 		{ return impossibleOp(); }
	public Literal neq(int value) 			{ return impossibleOp(); }
	public Literal neg() 					{ return impossibleOp(); }
	public Literal neg(int value) 			{ return impossibleOp(); }
	public Literal not() 					{ return impossibleOp(); }
	public Literal pos() 					{ return impossibleOp(); }
	public Literal and(Literal operand) 	{ return impossibleOp(); }
	public Literal and(boolean value) 		{ return impossibleOp(); }
	public Literal or(Literal operand) 		{ return impossibleOp(); }
	public Literal or(boolean value) 		{ return impossibleOp(); }
	public Literal eq(String value) 		{ return impossibleOp(); }
	public Literal neq(String value) 		{ return impossibleOp(); }
}
