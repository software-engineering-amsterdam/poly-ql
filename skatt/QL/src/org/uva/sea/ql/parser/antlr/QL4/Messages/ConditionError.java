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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConditionError other = (ConditionError) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		return true;
	}
	
	

}
