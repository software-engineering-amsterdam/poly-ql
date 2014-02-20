package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BoolLiteral;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Neg;
import org.uva.sea.ql.ast.operators.arithmetic.Pos;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.comparison.Eq;
import org.uva.sea.ql.ast.operators.comparison.GEq;
import org.uva.sea.ql.ast.operators.comparison.GT;
import org.uva.sea.ql.ast.operators.comparison.LEq;
import org.uva.sea.ql.ast.operators.comparison.LT;
import org.uva.sea.ql.ast.operators.comparison.NEq;
import org.uva.sea.ql.ast.operators.logical.And;
import org.uva.sea.ql.ast.operators.logical.Not;
import org.uva.sea.ql.ast.operators.logical.Or;
import org.uva.sea.ql.ast.type.Type;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {

	private TypeEnvironment environment;
	private List<Error> errorlist;
	
	public ExpressionChecker(TypeEnvironment environment, List<Error> errorlist) {
		this.environment = environment;
		this.errorlist = errorlist;
	}
	
	public static Boolean checkExpression(TypeEnvironment environment, List<Error> errorlist, Expression expression){

		ExpressionChecker checker = new ExpressionChecker(environment,errorlist);
		return expression.accept(checker);
	}
	
	public Boolean checkNormalExpression(Type type, Expression side){

		System.out.println("type of stat: " + type.show() + " expr: " + side.show() + " expr type: " + side.typeOf(environment).show());
		if(!(side.typeOf(environment).show() == type.show()))
		{
			newError(side.show() + " is not of type " + type.show()); //find a way to get left + right here
			return false;
		}
		return(checkExpression(environment,errorlist,side));
	}
	
	public Boolean checkComparison(Type type, Expression left, Expression right){
		if(!left.typeOf(environment).isCompatibleWith(right.typeOf(environment))){
			newError(left.show() + " cannot be compared with " + right.show());
			return false;
		}
		
		if(!(left.typeOf(environment) == type)){
			newError(left.show() + " is not of type " + type);
			return false;
		}
		
		if(!(right.typeOf(environment) == type)){
			newError(right.show() + " is not of type " + type);
			return false;
		}
		
		return checkExpression(environment,errorlist,left) && checkExpression(environment,errorlist,right);
		
	}

	public Boolean visit(Expression expression) {
		return expression.accept(this);		
	}


	public Boolean visit(Add add) {
		
		boolean left = checkNormalExpression(add.typeOf(environment), add.returnLeft());
		boolean right = checkNormalExpression(add.typeOf(environment), add.returnRight());
		return left && right;
	}

	public Boolean visit(Sub sub) {
		boolean left = checkNormalExpression(sub.typeOf(environment), sub.returnLeft());
		boolean right = checkNormalExpression(sub.typeOf(environment), sub.returnRight());
		return left && right;
	}

	public Boolean visit(Div div) {
		boolean left = checkNormalExpression(div.typeOf(environment), div.returnLeft());
		boolean right = checkNormalExpression(div.typeOf(environment), div.returnRight());
		return left && right;
	}

	public Boolean visit(Mul mul) {
		boolean left = checkNormalExpression(mul.typeOf(environment), mul.returnLeft());
		boolean right = checkNormalExpression(mul.typeOf(environment), mul.returnRight());
		return left && right;
	}

	public Boolean visit(Neg neg) {
		return checkNormalExpression(neg.typeOf(environment), neg.returnExpr());
	}

	public Boolean visit(Pos pos) {
		return checkNormalExpression(pos.typeOf(environment), pos.returnExpr());
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
		boolean left = checkNormalExpression(and.typeOf(environment), and.returnLeft());
		boolean right = checkNormalExpression(and.typeOf(environment), and.returnRight());
		return left && right;
	}

	public Boolean visit(Or or) {
		boolean left = checkNormalExpression(or.typeOf(environment), or.returnLeft());
		boolean right = checkNormalExpression(or.typeOf(environment), or.returnRight());
		return left && right;
	}

	public Boolean visit(Not not) {
		return checkNormalExpression(not.typeOf(environment),not.returnExpr());
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

	public Boolean visit(Identifier identifier) {
		return true;
	}
	
	private void newError(String error) {
		errorlist.add(new Error(error));
	}

}
