package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Pos extends UnaryOperator {

	public Pos(Expression expr) {
		
		super(expr);
	}

	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}

	@Override
	public String show() {
		return "";
	}
	
	

}
