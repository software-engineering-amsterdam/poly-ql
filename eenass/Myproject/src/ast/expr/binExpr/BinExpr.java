package ast.expr.binExpr;

import ast.expr.Expr;

public abstract class BinExpr extends Expr {
	private final Expr lhs;
	private final Expr rhs;
	
	public BinExpr(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;		
	}
	
	public Expr get_lhs(){
		return lhs;
	}

	public Expr get_rhs(){
		return rhs;
	}
	
}
