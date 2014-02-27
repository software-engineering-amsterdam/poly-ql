package ql.ast.expr.exprType;

import ql.ast.value.Value;

public class Ident extends Expr{
	public final String id;
	
	public Ident(String id){
		this.id = id;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}
}
