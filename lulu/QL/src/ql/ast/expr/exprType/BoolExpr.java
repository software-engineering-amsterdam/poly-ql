package ql.ast.expr.exprType;

import ql.ast.value.Bool;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class BoolExpr extends Expr{
	public final boolean bool;
	
	public BoolExpr(boolean bool){
		this.bool = bool;
	}
	
	public boolean getValue(){
		return bool;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return new Bool(bool);
	}
}
