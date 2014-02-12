package org.uva.sea.ql.ast.operators.comparison;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class LEq extends BinaryOperator {

	public LEq(Expression left, Expression right) {
		super(left,right);
	}

	public void accept(IOperatorVisitor visitor) {
		
		visitor.visit(this);	
		
	}

}
