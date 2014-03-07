package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

/** 
 * Equal to operator
 */
public class OperatorEq extends OperatorRelational {
	public OperatorEq(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}