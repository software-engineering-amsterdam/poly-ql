package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Not extends UnaryOperator {

	public Not(Expression expr) {
		
		super(expr);
	}

	public void accept(IOperatorVisitor visitor) {
		visitor.visit(this);
		
	}

}
