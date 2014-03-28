package ql.ast.expr.operation.un;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.message.Error;
import ql.ast.type.BoolType;
import ql.ast.type.Type;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class Not extends Operation{

	public Not(Expr expr) {
		super(expr);
	}
	
	public Value eval(Environment environment) {
		return new Bool(!((Bool)getExpr().eval(environment)).getValue());
	}

	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();	
		errors.addAll(getExpr().checkType(environment));	
		
		if(getExpr().getType(environment) != null && getExpr().getType(environment).getName() != "Bool")
			errors.add(new Error("!: Expression is not a boolean"));
		
		return errors;
	}
	
	public Type getType(Environment environment){
		return new BoolType();
	}
}
