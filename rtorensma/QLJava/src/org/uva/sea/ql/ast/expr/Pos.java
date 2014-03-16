package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.ExprVisitor;
import org.uva.sea.ql.checker.TypeEnvironment;


public class Pos extends UnaryExpr {

	public Pos(Expr expr) {
		super(expr);
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnv) {
		return new org.uva.sea.ql.ast.types.Int();
	}
	
	@Override
	public String getSymbol() {
		return "+";
	}
}
