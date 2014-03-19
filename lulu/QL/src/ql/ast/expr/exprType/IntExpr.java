package ql.ast.expr.exprType;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.message.Error;
import ql.ast.type.IntType;
import ql.ast.type.Type;
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
	public Value eval(Environment environment) {
		return new Int(num);
	}

	@Override
	public List<Error> checkType(Environment environment) {
		return new ArrayList<Error>();
	}

	@Override
	public Type getType(Environment environment) {
		return new IntType();
	}
}
