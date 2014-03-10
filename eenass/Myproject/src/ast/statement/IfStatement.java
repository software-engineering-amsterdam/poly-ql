package ast.statement;

import ast.Visitor;
import ast.expr.Expr;

public class IfStatement extends Block{
	
	private final Expr expr;

	public IfStatement(StatementList statements, Expr expr) {
		super(statements);
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
