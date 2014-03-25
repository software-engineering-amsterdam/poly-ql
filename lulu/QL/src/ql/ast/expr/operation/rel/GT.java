package ql.ast.expr.operation.rel;

import java.util.ArrayList;
import java.util.List;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.expr.operation.Operation;
import ql.ast.message.Error;
import ql.ast.type.BoolType;
import ql.ast.type.Type;
import ql.ast.value.Bool;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class GT extends Operation{

	public GT(Expr left, Expr right) {
		super(left, right);
	}

	public Value eval(Environment environment) {
		return new Bool(
				((Int)getLeft().eval(environment)).getValue()
				>
				((Int)getRight().eval(environment)).getValue()
				);
	}
	
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();
		
		errors.addAll(getLeft().checkType(environment));
		errors.addAll(getRight().checkType(environment));
		
		if(getLeft().getType(environment) != null && getLeft().getType(environment).getName() != "Int")
			errors.add(new Error(">: Left expression is not a integer"));
		
		if(getRight().getType(environment) != null && getRight().getType(environment).getName() != "Int")
			errors.add(new Error(">: Right expression is not a integer"));	
		
		return errors;
	}
	
	public Type getType(Environment environment){
		return new BoolType();
	}
}
