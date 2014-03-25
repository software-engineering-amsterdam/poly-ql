package expr.operation;

import expr.Expr;

public abstract class Operation extends Expr {
	
	private final Expr lhs;
	private final Expr rhs;
	
	public Operation(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;		
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}
	


	
	}
	
