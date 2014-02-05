package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.checker.ExprVisitor;


public class Div extends BinaryExpr {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}