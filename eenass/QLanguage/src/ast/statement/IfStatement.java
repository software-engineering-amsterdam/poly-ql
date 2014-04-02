package ast.statement;

import ast.expr.Expr;
import ast.visitors.StatementVisitor;

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
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
