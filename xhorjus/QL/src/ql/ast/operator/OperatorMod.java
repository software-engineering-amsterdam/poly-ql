package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

/** 
 * Add operator
 */
public class OperatorMod extends OperatorArithmetic {
	public OperatorMod(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}