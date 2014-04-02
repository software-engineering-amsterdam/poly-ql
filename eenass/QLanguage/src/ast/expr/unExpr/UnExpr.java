package ast.expr.unExpr;

import ast.expr.Expr;

public abstract class UnExpr extends Expr{
	
	private final Expr operand;
	
	public UnExpr(Expr operand){
		this.operand = operand;
	}

	public Expr getOperand() {
		return this.operand;
	}
}
