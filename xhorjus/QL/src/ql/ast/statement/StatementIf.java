package ql.ast.statement;

import java.util.List;

import ql.ast.ElementInterfaceVisitor;
import ql.ast.expression.ExpressionInterface;

public class StatementIf implements StatementInterface {
	private ExpressionInterface expression;
	private List<StatementInterface> ifStatements;
	private List<StatementInterface> elseStatements;
	
	public StatementIf(ExpressionInterface expression, List<StatementInterface> ifStatements, List<StatementInterface> elseStatements) {
		this.expression = expression;
		this.ifStatements = ifStatements;
		this.elseStatements = elseStatements;
	}
	
	public ExpressionInterface getExpression() {
		return this.expression;
	}
	
	public List<StatementInterface> getIfStatements() {
		return this.ifStatements;
	}
	
	public List<StatementInterface> getElseStatements() {
		return this.elseStatements;
	}

	@Override
	public void accept(ElementInterfaceVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public StatementTypeInterface getType() {
		return new StatementBoolean();
	}
}