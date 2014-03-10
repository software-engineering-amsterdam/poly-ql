package ql.ast.expr.operation.un;

import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class Not extends Operation{

	public Not(Expr expr) {
		super(expr);
		// TODO Auto-generated constructor stub
	}
	
	public Value eval() {
		return new Bool(!((Bool)getExpr().eval()).getValue());
	}

}
