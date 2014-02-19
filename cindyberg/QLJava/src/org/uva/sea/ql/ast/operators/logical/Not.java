package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Not extends UnaryOperator {

	public Not(Expression expr) {
		
		super(expr);
	}

	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "!";
	}

}
