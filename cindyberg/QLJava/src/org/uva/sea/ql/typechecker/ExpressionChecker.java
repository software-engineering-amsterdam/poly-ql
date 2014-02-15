package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {

	public Environment environment;
	public List<Error> errors;
	
	public ExpressionChecker(Environment environment, List<Error> errorlist) {
		this.environment = environment;
		this.errors = errorlist;
	}

	public Boolean visit(Add add) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Sub sub) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Div div) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Mul mul) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Eq eq) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(GEq geq) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(GT gt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(LEq leq) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(LT lt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(NEq neq) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(And and) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean visit(Not not) {
		// TODO Auto-generated method stub
		return null;
	}

}
