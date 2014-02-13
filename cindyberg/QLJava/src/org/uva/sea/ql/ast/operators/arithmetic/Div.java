package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class Div extends BinaryOperator {
	
	public Div(Expression left, Expression right) {
		
		super(left,right);
	}

	public void accept(IOperatorVisitor visitor) {
		
		visitor.visit(this);
		
	}

}
