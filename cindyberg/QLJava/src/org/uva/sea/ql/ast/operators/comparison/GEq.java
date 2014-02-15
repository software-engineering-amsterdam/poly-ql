package org.uva.sea.ql.ast.operators.comparison;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class GEq extends BinaryOperator{

	public GEq(Expression left, Expression right) {

		super(left,right);
	}

	public void accept(IVisitor visitor) {
		
		visitor.visit(this);
		
	}
	
	public String show(){
		return ">=";
	}
}
