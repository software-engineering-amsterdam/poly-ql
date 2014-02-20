package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.checker.FormVisitor;

public class IfThenElse extends IfThen {
	private final Stat elseBody;

	public IfThenElse(Expr cond, Stat body, Stat elseBody) {
		super(cond, body);
		this.elseBody = elseBody;
	}
	
	public Stat getElseBody() {
		return elseBody;
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
