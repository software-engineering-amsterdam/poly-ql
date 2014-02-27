package ql.ast.expr.operation.andor;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class And extends Operation{

	public And(Expr left, Expr right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Value eval() {
		return new Bool(
				(((Bool)getLeft().eval()).getValue()) && (((Bool)getRight().eval()).getValue())
				);
	}
}
