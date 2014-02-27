package ql.ast.expr.operation.rel;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Bool;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class LT extends Operation{

	public LT(Expr left, Expr right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Value eval() {
		return new Bool(
				((Int)getLeft().eval()).getValue()
				<
				((Int)getRight().eval()).getValue()
				);
	}
}
