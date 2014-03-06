package ql.ast;

import ql.ast.expression.ExpressionInterface;
import ql.ast.statement.StatementTypeInterface;
import ql.ast.type.TypeInterface;

/**
 * Check expressions for validity.
 */
public class ValidityExpression implements ValidityInterface {
	//private TypeVisitor visitor;
	private ExpressionInterface expression;
	
	/* Constructor */
	public ValidityExpression(TypeVisitor visitor, ExpressionInterface expression) { 
		//this.visitor    = visitor;
		this.expression = expression;
	}
	
	/* Check if statement type is compatible */
	public boolean statementTypeCompatible(StatementTypeInterface type) {
		return this.expression.getType().getClass().equals(type.getType().getClass());
	}
	
	/* Check if type is compatible */
	public boolean typeCompatible(TypeInterface type) {
		return this.expression.getType().getClass().equals(type.getClass());
	}
}