package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents the error of an invalid type in an expression
 * @author Sammie Katt
 *
 */
public class InvalidTypeError extends QLErrorMsg {

	private final Expression expr;

	public InvalidTypeError(Expression expr) {
		this.expr = expr;
	}
	
	@Override
	public String toString() {
		return "Expression " + expr + " does not contain expected type";
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
		InvalidTypeError other = (InvalidTypeError) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		return true;
	}

	
	
}
