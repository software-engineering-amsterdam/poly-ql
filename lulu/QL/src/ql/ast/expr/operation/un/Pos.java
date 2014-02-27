package ql.ast.expr.operation.un;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class Pos extends Operation{

	public Pos(Expr expr) {
		super(expr);
		// TODO Auto-generated constructor stub
	}

	public Value eval() {
		return new Int(((Int)getExpr().eval()).getValue());
	}
}
