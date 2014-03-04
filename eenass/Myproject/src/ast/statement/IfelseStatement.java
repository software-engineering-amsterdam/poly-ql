package ast.statement;

import ast.Visitor;
import ast.expr.Expr;

public class IfelseStatement extends IfStatement{

	private final StatementList elseStatements;
	
	public IfelseStatement(StatementList ifStatements, Expr expr, StatementList elseStatements) {
		super(ifStatements, expr);
		this.elseStatements = elseStatements;
	}
	public StatementList getElseStatements() {
		return elseStatements;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
