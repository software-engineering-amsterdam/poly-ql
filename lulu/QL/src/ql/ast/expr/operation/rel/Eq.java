package ql.ast.expr.operation.rel;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class Eq extends Operation{

	public Eq(Expr left, Expr right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Value eval() {
		return new Bool(getLeft().eval().equals(getRight().eval()));
	}
}
