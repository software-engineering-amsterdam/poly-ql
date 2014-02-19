package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;


public class Add extends BinaryOperator {

	
	public Add(Expression left, Expression right){
		
		super(left,right);
	}

	
	public String show(){
		return "+";
	}

	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}

}
