package org.uva.sea.ql.checker.exception.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;

public abstract class IllegalTypeError extends TypeError {
	
	private static final long serialVersionUID = 1L;
	
	protected Expr expr;
	protected Type given;

	public IllegalTypeError(Expr expr, Type given) {
		this.expr = expr;
		this.given = given;
	}

}
