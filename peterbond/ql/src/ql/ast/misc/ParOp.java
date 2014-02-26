package ql.ast.misc;

import ql.ast.expressions.ExprInterface;
import ql.ast.types.TInterface;
import ql.ast.EInterfaceVisitor;

public class ParOp implements ExprInterface {
	private final ExprInterface expression;
	
	public ParOp(ExprInterface expression) {
		this.expression = expression;
	}

	@Override
	public TInterface getType() {
		return this.expression.getType();
	}

	@Override
	public void accept(EInterfaceVisitor visitor) {
		visitor.visit(this);
	}

}