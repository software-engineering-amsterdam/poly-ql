package ql.ast.operators;

import ql.ast.expressions.ExprInterface;
import ql.ast.types.TMoney;
import ql.ast.EInterfaceVisitor;

public class DivOp extends BinOp {
	public DivOp(ExprInterface left, ExprInterface right) {
		super(left, right);
	}

	@Override
	public TMoney getType() {
		return new TMoney();
	}

	@Override
	public void accept(EInterfaceVisitor visitor) {
		visitor.visit(this);
	}
	
}
