package ql.ast.expr.exprType;

import ql.ast.value.Int;
import ql.ast.value.Value;

public class IntExpr extends Expr{
	private final int num;
	
	public IntExpr(int num){
		this.num = num;
	}
	
	public int getValue(){
		return num;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return new Int(num);
	}
}
