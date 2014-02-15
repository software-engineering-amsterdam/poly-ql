package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BoolLiteral;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {

	public Environment environment;
	public List<Error> errors;
	
	public ExpressionChecker(Environment environment, List<Error> errorlist, Expression expression) {
		this.environment = environment;
		this.errors = errorlist;
		expression.accept(this);
	}
	
	public Boolean checkArithmetic(Expression side){
		return true;
	}

	public Boolean visit(Expression expression) {
		return null;
		// TODO Auto-generated method stub
		
	}


	public Boolean visit(Add add) {
		boolean left = checkArithmetic(add.returnLeft());
		boolean right = checkArithmetic(add.returnRight());
		return left && right;
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


	public Boolean visit(IntLiteral intLiteral) {
		return true;
	}


	public Boolean visit(BoolLiteral boolLiteral) {
		return true;
	}


	public Boolean visit(StringLiteral stringLiteral) {
		return true;
	}

}
