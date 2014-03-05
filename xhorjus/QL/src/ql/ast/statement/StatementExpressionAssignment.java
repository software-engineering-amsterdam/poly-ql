package ql.ast.statement;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

/**
 * Class for assignment statements with an expression. 
 * An assignment consists of a question ID, its contents, 
 * a type and an expression.
 */
public class StatementExpressionAssignment implements StatementInterface {
	private String ID;
	private String content;
	private StatementTypeInterface type;
	private ExpressionInterface expression;

	/* Constructor */
	public StatementExpressionAssignment(
			String ID, 
			String content,
			StatementTypeInterface statementTypeInterface,
			ExpressionInterface expression) 
	{
		this.ID = ID;
		this.content = content;
		this.type = statementTypeInterface;
		this.expression = expression;
	}

	/* Visitor */
	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}

	/* Return question ID */
	public String getID() {
		return this.ID;
	}

	/* Return question content */
	public String getContent() {
		return this.content;
	}

	/* Return question expression */
	public ExpressionInterface getExpression() {
		return this.expression;
	}

	/* Return question type */
	@Override
	public StatementTypeInterface getType() {
		return this.type;
	}

}