package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public abstract class IllegalStringError extends IllegalTypeError {
	
	public IllegalStringError(Expr expr, Type given) {
		super(expr, given);
	}

	public String getMessage(Expr ex, Type given){
		return "string value expected; << "+expr+" ("+given+") >> given.";
	}

}
