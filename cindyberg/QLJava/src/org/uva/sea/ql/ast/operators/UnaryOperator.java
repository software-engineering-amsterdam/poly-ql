package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class UnaryOperator extends Expression{
	
	public Expression expr;

	public UnaryOperator(Expression expr) {
		
		this.expr = expr;
		
	}
	
	public Expression getExpr(){
		return this.expr;
	}

}
