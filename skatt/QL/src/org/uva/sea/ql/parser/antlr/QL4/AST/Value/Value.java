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

	/**
	 * Throw unsupported operation for binary mathematical double dispatch
	 */
	public Value plusNumber(Number val) {
		throw new UnsupportedOperationException();
	}
	
	public Value minNumber(Number  val) {
		throw new UnsupportedOperationException();
	}

	public Value multNumber(Number val) {
		throw new UnsupportedOperationException();
	}
	
	public Value divNumber(Number  val) {
		throw new UnsupportedOperationException();
	}

	public Value plusDec(Decimal val) {
		throw new UnsupportedOperationException();
	}
	
	public Value minDec(Decimal val) {
		throw new UnsupportedOperationException();
	}
	
	public Value divDec(Decimal decimal) {
		throw new UnsupportedOperationException();
	}
	
	public Value multDec(Decimal decimal) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Throw unsupported operation for binary relation double dispatch
	 */

	public Value geqNumber(Number number) {
		throw new UnsupportedOperationException();
	}
	
	public Value leqNumber(Number number) {
		throw new UnsupportedOperationException();
	}
	
	public Value greNumber(Number number) {
		throw new UnsupportedOperationException();
	}
	
	public Value lesNumber(Number number) {
		throw new UnsupportedOperationException();
	}
	
	public Value geqDec(Decimal dec) {
		throw new UnsupportedOperationException();
	}
	
	public Value leqDec(Decimal dec) {
		throw new UnsupportedOperationException();
	}
	
	public Value greDec(Decimal dec) {
		throw new UnsupportedOperationException();
	}
	
	public Value lesDec(Decimal dec) {
		throw new UnsupportedOperationException();
	}
	
}
