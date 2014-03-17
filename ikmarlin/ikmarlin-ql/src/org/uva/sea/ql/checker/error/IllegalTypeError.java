package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public abstract class IllegalTypeError extends TypeError {
	
	protected Expr expr;
	protected Type given;

	public IllegalTypeError(Expr expr, Type given) {
		this.expr = expr;
		this.given = given;
	}

}
