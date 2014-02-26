package ql.ast.operator;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeInterface;
import ql.ast.type.TypeMoney;

/** 
 * Modulo operator (remainder)
 */
public class OperatorMod extends BinaryOperator {
	public OperatorMod(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override
	public TypeInterface getType() {
		return new TypeMoney();
	}

	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}