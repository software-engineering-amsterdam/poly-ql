package ql.ast.expression;

import ql.ast.type.*;
import ql.ast.*;

/**
 * Expression class for parentheses
 */
public class ExpressionParentheses implements ExpressionInterface {
	ExpressionInterface expression;
	
	public ExpressionParentheses(ExpressionInterface expression) {
		this.expression = expression;
	}
	
	@Override
	public TypeInterface getType() {
		return this.expression.getType();
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}