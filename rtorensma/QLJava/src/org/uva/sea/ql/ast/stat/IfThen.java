package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.checker.FormVisitor;

public class IfThen extends Stat {
	private final Expr cond;
	private final Stat body;
	
	public IfThen(Expr cond, Stat body) {
		this.cond = cond;
		this.body = body;
	}
	
	public Expr getCond() {
		return cond;
	}
	
	public Stat getBody() {
		return body;
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
