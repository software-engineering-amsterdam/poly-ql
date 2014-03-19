package ql.ast.expr.operation;

import java.util.List;


import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.message.Error;
import ql.ast.type.Type;
import ql.ast.value.Value;

public class Operation extends Expr{
	private Expr left = null;
	private Expr right = null;
	private Expr expr = null;
	
	public Operation(Expr left, Expr right){
		this.left = left;
		this.right = right;
	}
	
	public Operation(Expr expr){
		this.expr = expr;
	}

	public Expr getLeft() {
		return left;
	}

	public Expr getRight() {
		return right;
	}

	public Expr getExpr() {
		return expr;
	}
	

	@Override
	public Value eval(Environment environment) {
		return null;
	}

	@Override
	public List<Error> checkType(Environment environment) {
		return null;
	}

	@Override
	public Type getType(Environment environment) {
		return null;
	}
	
		
}
