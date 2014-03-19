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
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.Type;

import problems.CompatibleError;
import problems.NotDeclaredError;
import problems.Problems;
import problems.TypeError;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {

	private TypeEnvironment environment;
	private Problems problems;
	private MissingType UNDEFINED = new MissingType(); 
	
	public ExpressionChecker(TypeEnvironment environment, Problems problems) {
		this.environment = environment;
		this.problems = problems;
	}
	
	public static Boolean checkExpression(TypeEnvironment environment, Problems problems, Expression expression){

		ExpressionChecker checker = new ExpressionChecker(environment,problems);
		return expression.accept(checker);
	}
	
	private Boolean checkBinaryExpression(Type type, Expression left, Expression right){
		checkType(type, left);
		checkType(type, right);
		return left.accept(this) && right.accept(this);
	}

	private void checkType(Type type, Expression expression) {
		if (!isUndefined(expression) && !typeOf(expression).equals(type)){
			problems.addError(new TypeError(expression, type));
		}
	}
	
	private boolean isUndefined(Expression expression){
		return typeOf(expression).equals(UNDEFINED);
	}
	
	private Type typeOf(Expression expression){
		return expression.typeOf(environment);
	}
	
	private boolean checkUnaryExpression(Type type, Expression side){
		checkType(type,side);
		return side.accept(this);
	}
	
	private boolean checkComparison(Type type, Expression left, Expression right){
		if(!typeOf(left).isCompatibleWith(typeOf(right))){
			problems.addError(new CompatibleError(left,right,environment));
			return false;
		}

		return checkExpression(environment,problems,left) && checkExpression(environment,problems,right);
		
	}

	public boolean visit(Expression expression) {
		return expression.accept(this);		
	}


	public Boolean visit(Add add) {
		return checkBinaryExpression(add.typeOf(environment), add.getLeftHand(),add.getRightHand());
	}

	public Boolean visit(Sub sub) {
		return checkBinaryExpression(sub.typeOf(environment), sub.getLeftHand(), sub.getRightHand());
	}

	public Boolean visit(Div div) {
		return checkBinaryExpression(div.typeOf(environment), div.getLeftHand(), div.getRightHand());
	}

	public Boolean visit(Mul mul) {
		return checkBinaryExpression(mul.typeOf(environment), mul.getLeftHand(), mul.getRightHand());
	}

	public Boolean visit(Neg neg) {
		return checkUnaryExpression(neg.typeOf(environment), neg.getExpr());
	}

	public Boolean visit(Pos pos) {
		return checkUnaryExpression(pos.typeOf(environment), pos.getExpr());
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
		return checkBinaryExpression(and.typeOf(environment), and.getLeftHand(), and.getRightHand());
	}

	public Boolean visit(Or or) {
		return checkBinaryExpression(or.typeOf(environment), or.getLeftHand(), or.getRightHand());
	}

	public Boolean visit(Not not) {
		return checkUnaryExpression(not.typeOf(environment),not.getExpr());
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
		if(environment.isDeclared(identifier)){
			return true;
		}
		problems.addError(new NotDeclaredError(identifier));
		return false;
	}

}
