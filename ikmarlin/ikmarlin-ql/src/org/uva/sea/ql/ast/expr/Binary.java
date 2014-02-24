package org.uva.sea.ql.ast.expr;

public abstract class Binary extends Expr {
	private Expr lhs;
	private Expr rhs;
	
	public Binary(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs(){
		return this.lhs;
	}
	
	public Expr getRhs(){
		return this.rhs;
	}
	
	public  abstract String toString();
	
}
