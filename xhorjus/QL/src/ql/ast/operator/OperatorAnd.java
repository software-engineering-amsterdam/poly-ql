package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

/** 
 * Logical AND operator
 */
public class OperatorAnd extends OperatorConditional {
	public OperatorAnd(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}