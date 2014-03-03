package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public abstract class IllegalArithmeticError extends IllegalTypeError {
	
	public static String getMessage(Expr ex, Type given){
		return "numeric value expected. << "+ex.toString()+" ("+given+") >> given.";
	}

}
