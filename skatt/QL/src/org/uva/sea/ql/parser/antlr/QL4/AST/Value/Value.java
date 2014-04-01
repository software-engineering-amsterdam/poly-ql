package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Parent class for all literal clauses in the QL4 syntax (all values e.g. number)
 * @author Sammie Katt
 */
public abstract class Value extends Expression {

	public Value Negate() {
		throw new UnsupportedOperationException();
	}
	
}
