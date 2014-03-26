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
import ql.ast.value.Value;

public class NEq extends Operation{

	public NEq(Expr left, Expr right) {
		super(left, right);
	}
	
	public Value eval(Environment environment) {
		return new Bool(!getLeft().eval(environment).equals(getRight().eval(environment)));
	}
	
	public List<Error> checkType(Environment environment) {
		List<Error> errors = new ArrayList<Error>();
		
		errors.addAll(getLeft().checkType(environment));
		errors.addAll(getRight().checkType(environment));
		
		if(getLeft().getType(environment) != null && getRight().getType(environment) != null && getLeft().getType(environment).getName() != getRight().getType(environment).getName())
			errors.add(new Error("!=: Types of left expression and right expression are not the same"));
			
		return errors;
	}
	
	public Type getType(Environment environment){
		return new BoolType();
	}
}
