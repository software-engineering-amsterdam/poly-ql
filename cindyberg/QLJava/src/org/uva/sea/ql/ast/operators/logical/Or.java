package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Or extends BinaryOperator {

	public Or(Expression left,Expression right) {
		super(left,right);
	}

	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "||";
	}

}
