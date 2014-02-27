package ql.ast.expr.operation.mul;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class Div extends Operation{

	public Div(Expr left, Expr right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Value eval() {
		return new Int(
				(((Int)getLeft().eval()).getValue())/(((Int)getRight().eval()).getValue())
				);
	}
}
