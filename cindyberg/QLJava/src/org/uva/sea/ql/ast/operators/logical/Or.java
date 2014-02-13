package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class Or extends BinaryOperator {

	public Or(Expression left,Expression right) {
		super(left,right);
	}

	public void accept(IOperatorVisitor visitor) {
		
		visitor.visit(this);
		
	}

}
