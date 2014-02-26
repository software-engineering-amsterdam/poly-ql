package ql.ast.operators;

import ql.ast.expressions.ExprInterface;
import ql.ast.EInterfaceVisitor;
import ql.ast.types.TBoolean;

public class NegOp extends UnOp{
	public NegOp(ExprInterface expression) {
		super(expression);
	}

	@Override
	public TBoolean getType() {
		return new TBoolean();
	}
	
	@Override
	public void accept(EInterfaceVisitor visitor) {
		visitor.visit(this);
	}
}
