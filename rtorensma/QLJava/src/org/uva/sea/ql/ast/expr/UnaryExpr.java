package org.uva.sea.ql.ast.expr;

public abstract class UnaryExpr extends Expr {
	private final Expr expr;
	
	public UnaryExpr(Expr arg) {
		this.expr = arg;
	}
	
	public Expr getExpr() {
		return expr;
	}

	public abstract String getSymbol();
}
