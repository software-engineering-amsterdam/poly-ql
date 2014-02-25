package ql.ast.operators;

import ql.ast.expressions.ExprInterface;
import ql.ast.types.TBoolean;
import ql.ast.EInterfaceVisitor;

public class LtEqOp extends BinOp {
	public LtEqOp	(ExprInterface left, ExprInterface right) {
		super(left, right);
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
