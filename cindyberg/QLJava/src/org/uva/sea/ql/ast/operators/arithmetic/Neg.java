package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.IOperatorVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Neg extends UnaryOperator {

	public Neg(Expression expr) {
		super(expr);
	}

	public void accept(IOperatorVisitor visitor) {
		
		visitor.visit(this);
		
	}

}
