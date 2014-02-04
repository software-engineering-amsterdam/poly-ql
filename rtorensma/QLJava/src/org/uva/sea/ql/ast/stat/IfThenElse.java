package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThenElse extends IfThen {
	private final Stat elseBody;

	public IfThenElse(Expr cond, Stat body, Stat elseBody) {
		super(cond, body);
		this.elseBody = elseBody;
	}
	
	public Stat getElseBody() {
		return elseBody;
	}
}
