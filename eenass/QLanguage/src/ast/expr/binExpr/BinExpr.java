package ast.expr.binExpr;

import ast.expr.Expr;

public abstract class BinExpr extends Expr {
	
	private final Expr lhs;
	private final Expr rhs;
	
	public BinExpr(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;		
	}
	
	public Expr getLhs(){
		return lhs;
	}

	public Expr getRhs(){
		return rhs;
	}
	
}
