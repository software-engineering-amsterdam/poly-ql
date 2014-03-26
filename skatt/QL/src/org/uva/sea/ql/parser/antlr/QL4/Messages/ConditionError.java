package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * The error thrown when a condition does not evaluate to a boolean.
 * @author Sammie Katt
 *
 */
public class ConditionError extends QLErrorMsg {

	private final Expression expr;
	public ConditionError(Expression expr) {
		this.expr = expr;
	}
	
	@Override
	public String toString() {
		return "Expression " + expr + " does not return a boolean";
	}
	

}
