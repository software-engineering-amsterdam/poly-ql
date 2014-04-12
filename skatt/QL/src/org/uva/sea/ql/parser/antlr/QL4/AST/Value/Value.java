package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Parent class for all literal clauses in the QL4 syntax (all values e.g. number)
 * @author Sammie Katt
 */
public abstract class Value extends Expression {

	public Value negate() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary equality expressions
	 */
	public Value eq(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value val) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary logical expressions
	 */
	public Value and(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Value val) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary relational expressions
	 */
	public Value geq(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value gre(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value les(Value val) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary mathematical expressions
	 */
	public Value plus(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value min(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value div(Value val) {
		throw new UnsupportedOperationException();
	}
	
	public Value mult(Value val) {
		throw new UnsupportedOperationException();
	}

	
	/**
	 * Throw unsupported operation for binary logical double dispatch
	 */
	public Value orBool(Bool bool) {
		throw new UnsupportedOperationException();
	}
	
	public Value andBool(Bool bool) {
		throw new UnsupportedOperationException();
	}


	
}
