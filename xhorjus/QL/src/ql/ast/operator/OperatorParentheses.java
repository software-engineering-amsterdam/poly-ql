package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeInterface;

public class OperatorParentheses implements ExpressionInterface {
	ExpressionInterface expression;

	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeInterface getType() {
		return this.expression.getType();
	}
	
	
}