package ql.ast.expr.operation;

import ql.ast.expr.exprType.Expr;

public class Operation extends Expr{
	private Expr left = null;
	private Expr right = null;
	private Expr expr = null;
	
	public Operation(Expr left, Expr right){
		this.left = left;
		this.right = right;
	}
	
	public Operation(Expr expr){
		this.expr = expr;
	}

	public Expr getLeft() {
		return left;
	}

	public Expr getRight() {
		return right;
	}

	public Expr getExpr() {
		return expr;
	}
		
}
