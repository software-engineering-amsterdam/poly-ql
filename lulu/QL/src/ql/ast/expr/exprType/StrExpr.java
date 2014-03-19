package ql.ast.expr.exprType;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.message.Error;
import ql.ast.type.StrType;
import ql.ast.type.Type;
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
	public Value eval(Environment valueEnvironment) {
		return new Str(str);
	}

	@Override
	public List<Error> checkType(Environment environment) {
		return new ArrayList<Error>();
	}

	@Override
	public Type getType(Environment environment) {
		return new StrType();
	}
}
