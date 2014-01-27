package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Conditional extends Stat {
	private final Expr cond;
	private final Stat body;

	public Conditional(Expr cond, Stat body) {
		this.cond = cond;
		this.body = body;
	}
	
	public Expr getCond() {
		return cond;
	}
	
	public Stat getBody() {
		return body;
	}


}
