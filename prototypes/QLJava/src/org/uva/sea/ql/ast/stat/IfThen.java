package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThen extends Conditional {
	public IfThen(Expr cond, Stat body) {
		super(cond, body);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
