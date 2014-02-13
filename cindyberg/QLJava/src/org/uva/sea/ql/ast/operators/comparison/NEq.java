package org.uva.sea.ql.ast.operators.comparison;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class NEq extends BinaryOperator{

	public NEq(Expression left, Expression right) {
		super(left,right);
	}

	public void accept(IOperatorVisitor visitor) {
		
		visitor.visit(this);
		
	}

}
