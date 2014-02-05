package org.uva.sea.ql.ast.expr;

public abstract class UnaryExpr extends Expr {
	private final Expr expr;
	protected String symbol = "";
	
	public UnaryExpr(Expr arg) {
		this.expr = arg;
	}
	
	public Expr getExpr() {
		return expr;
	}

	public String getSymbol() {
		return symbol;
	}
}
