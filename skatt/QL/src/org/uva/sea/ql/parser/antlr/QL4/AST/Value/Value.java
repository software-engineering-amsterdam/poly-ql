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
	public Value eq(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary logical expressions
	 */
	public Value and(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary relational expressions
	 */
	public Value geq(Expression expr) {
		throw new UnsupportedOperationException();
	}

	public Value gre(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value les(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary mathematical expressions
	 */
	public Value plus(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value min(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value div(Expression expr) {
		throw new UnsupportedOperationException();
	}
	
	public Value mult(Expression expr) {
		throw new UnsupportedOperationException();
	}


	
}
