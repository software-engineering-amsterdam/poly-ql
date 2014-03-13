package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public class IllegalBooleanError extends IllegalTypeError {
	
	public IllegalBooleanError(Expr expr, Type given) {
		super(expr, given);
	}
	
	@Override
	public String getMessage(){
		return "boolean value expected; << "+expr+" ("+given+") >> given.";
	}

}
