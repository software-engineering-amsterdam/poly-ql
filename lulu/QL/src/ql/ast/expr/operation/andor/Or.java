package ql.ast.expr.operation.andor;

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

public class Or extends Operation{

	public Or(Expr left, Expr right) {
		super(left, right);
	}

	public Value eval(Environment environment) {
		return new Bool(
				(((Bool)getLeft().eval(environment)).getValue()) || (((Bool)getRight().eval(environment)).getValue())
				);
	}
	
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();
		
		errors.addAll(getLeft().checkType(environment));
		errors.addAll(getRight().checkType(environment));
	
		if(getLeft().getType(environment) != null && getLeft().getType(environment).getName() != "Bool")
			errors.add(new Error("||: Left expression is not a boolean"));
		
		if(getRight().getType(environment) != null && getRight().getType(environment).getName() != "Bool")
			errors.add(new Error("||: Right expression is not a boolean"));	
		
		return errors;
	}
	
	public Type getType(Environment environment){
		return new BoolType();
	}
}
