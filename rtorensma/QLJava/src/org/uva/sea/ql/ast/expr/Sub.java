package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.checker.ExprVisitor;


public class Sub extends BinaryExpr {

	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
