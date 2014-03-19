package ql.ast.expr.exprType;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.message.Error;
import ql.ast.type.BoolType;
import ql.ast.type.Type;
import ql.ast.value.Bool;
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
	public Value eval(Environment environment) {
		return new Bool(bool);
	}

	@Override
	public List<Error> checkType(Environment environment) {
		return new ArrayList<Error>();
	}

	@Override
	public Type getType(Environment environment) {
		return new BoolType();
	}
}
