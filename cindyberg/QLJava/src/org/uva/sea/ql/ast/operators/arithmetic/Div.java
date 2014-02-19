package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Div extends BinaryOperator {
	
	public Div(Expression left, Expression right) {
		
		super(left,right);
	}

	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "/";
	}
}
