package ql.ast.expr.operation.add;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.exprType.IntExpr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Value;
import ql.ast.value.Int;

public class Add extends Operation{

	public Add(Expr left, Expr right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	public Value eval() {
		return new Int(
				((Int)getLeft().eval()).getValue()
				+
				((Int)getRight().eval()).getValue()
				);
	}
}
