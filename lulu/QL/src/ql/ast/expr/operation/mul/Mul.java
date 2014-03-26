package ql.ast.expr.operation.mul;

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

public class Mul extends Operation{

	public Mul(Expr left, Expr right) {
		super(left, right);
	}

	public Value eval(Environment valueEnvironment) {
		return new Int(
				((Int)getLeft().eval(valueEnvironment)).getValue()
				*
				((Int)getRight().eval(valueEnvironment)).getValue()
				);
	}
	
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();
		
		errors.addAll(getLeft().checkType(environment));
		errors.addAll(getRight().checkType(environment));
		
		if(getLeft().getType(environment) != null && getLeft().getType(environment).getName() != "Int")
			errors.add(new Error("*: Left expression is not a integer"));
		
		if(getRight().getType(environment) != null && getRight().getType(environment).getName() != "Int")
			errors.add(new Error("*: Right expression is not a integer"));
			
		return errors;
	}
	
	public Type getType(Environment environment){
		return new IntType();
	}
}
