package ql.ast.expr.operation.un;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.message.Error;
import ql.ast.type.IntType;
import ql.ast.type.Type;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class Pos extends Operation{

	public Pos(Expr expr) {
		super(expr);
	}

	public Value eval(Environment environment) {
		return new Int(((Int)getExpr().eval(environment)).getValue());
	}
	
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();	
		errors.addAll(getExpr().checkType(environment));	
		
		if(getExpr().getType(environment) != null && getExpr().getType(environment).getName() != "Int")
			errors.add(new Error("+: Expression is not a integer"));
		
		return errors;
	}
	
	public Type getType(Environment environment){
		return new IntType();
	}
}
