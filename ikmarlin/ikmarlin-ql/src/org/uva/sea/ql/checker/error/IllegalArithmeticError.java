package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public class IllegalArithmeticError extends IllegalTypeError {
	
	public IllegalArithmeticError(Expr expr, Type given) {
		super(expr, given);
	}

	public String getMessage() {
		return "numeric value expected; << " + expr + " (" + given + ") >> given.";
	}

}
