package ql.ast.expr.exprType;

import ql.ast.value.Str;
import ql.ast.value.Value;

public class StrExpr extends Expr{
	private final String str;
	
	public StrExpr(String str){
		this.str = str;
	}
	
	public String getValue(){
		return str;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return new Str(str);
	}
}
