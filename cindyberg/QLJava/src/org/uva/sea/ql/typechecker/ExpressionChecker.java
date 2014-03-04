package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BooleanLiteral;
import org.uva.sea.ql.ast.literal.IntegerLiteral;
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
	private Problems problems;
	
	public ExpressionChecker(TypeEnvironment environment, Problems problems) {
		this.environment = environment;
		this.problems = problems;
	}
	
	public static Boolean checkExpression(TypeEnvironment environment, Problems problems, Expression expression){

		ExpressionChecker checker = new ExpressionChecker(environment,problems);
		return expression.accept(checker);
	}
	
	public Boolean checkNormalExpression(Type type, Expression side){

		if(!(side.typeOf(environment).show() == type.show()))
		{
			problems.addError(side.show() + " is not of type " + type.show()); //find a way to get left + right here
			return false;
		}
		return(checkExpression(environment,problems,side));
	}
	
	public Boolean checkComparison(Type type, Expression left, Expression right){
		if(!left.typeOf(environment).isCompatibleWith(right.typeOf(environment))){
			problems.addError(left.show() + " cannot be compared with " + right.show());
			return false;
		}

		return checkExpression(environment,problems,left) && checkExpression(environment,problems,right);
		
	}

	public Boolean visit(Expression expression) {
		return expression.accept(this);		
	}


	public Boolean visit(Add add) {
		
		boolean left = checkNormalExpression(add.typeOf(environment), add.getLeftHand());
		boolean right = checkNormalExpression(add.typeOf(environment), add.getRightHand());
		return left && right;
	}

	public Boolean visit(Sub sub) {
		boolean left = checkNormalExpression(sub.typeOf(environment), sub.getLeftHand());
		boolean right = checkNormalExpression(sub.typeOf(environment), sub.getRightHand());
		return left && right;
	}

	public Boolean visit(Div div) {
		boolean left = checkNormalExpression(div.typeOf(environment), div.getLeftHand());
		boolean right = checkNormalExpression(div.typeOf(environment), div.getRightHand());
		return left && right;
	}

	public Boolean visit(Mul mul) {
		boolean left = checkNormalExpression(mul.typeOf(environment), mul.getLeftHand());
		boolean right = checkNormalExpression(mul.typeOf(environment), mul.getRightHand());
		return left && right;
	}

	public Boolean visit(Neg neg) {
		return checkNormalExpression(neg.typeOf(environment), neg.getExpr());
	}

	public Boolean visit(Pos pos) {
		return checkNormalExpression(pos.typeOf(environment), pos.getExpr());
	}

	public Boolean visit(Eq eq) {
		return checkComparison(eq.typeOf(environment), eq.getLeftHand(), eq.getRightHand());
	}

	public Boolean visit(GEq geq) {
		return checkComparison(geq.typeOf(environment), geq.getLeftHand(), geq.getRightHand());
	}

	public Boolean visit(GT gt) {
		return checkComparison(gt.typeOf(environment), gt.getLeftHand(), gt.getRightHand());
	}

	public Boolean visit(LEq leq) {
		return checkComparison(leq.typeOf(environment), leq.getLeftHand(), leq.getRightHand());
	}

	public Boolean visit(LT lt) {
		return checkComparison(lt.typeOf(environment), lt.getLeftHand(), lt.getRightHand());
	}

	public Boolean visit(NEq neq) {
		return checkComparison(neq.typeOf(environment), neq.getLeftHand(), neq.getRightHand());
	}

	public Boolean visit(And and) {
		boolean left = checkNormalExpression(and.typeOf(environment), and.getLeftHand());
		boolean right = checkNormalExpression(and.typeOf(environment), and.getRightHand());
		return left && right;
	}

	public Boolean visit(Or or) {
		boolean left = checkNormalExpression(or.typeOf(environment), or.getLeftHand());
		boolean right = checkNormalExpression(or.typeOf(environment), or.getRightHand());
		return left && right;
	}

	public Boolean visit(Not not) {
		return checkNormalExpression(not.typeOf(environment),not.getExpr());
	}


	public Boolean visit(IntegerLiteral intLiteral) {
		return true;
	}


	public Boolean visit(BooleanLiteral boolLiteral) {
		return true;
	}


	public Boolean visit(StringLiteral stringLiteral) {
		return true;
	}

	public Boolean visit(Identifier identifier) {
		return true;
	}

}
