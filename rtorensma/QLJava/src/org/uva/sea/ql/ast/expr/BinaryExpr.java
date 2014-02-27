package org.uva.sea.ql.ast.expr;

public abstract class BinaryExpr extends Expr {
	private final Expr lhs, rhs;
	
	public BinaryExpr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

	public abstract String getSymbol();
	
	@Override
	public String toString() {
		return String.format("%s %s %s", lhs, getSymbol(), rhs);
	}
}
