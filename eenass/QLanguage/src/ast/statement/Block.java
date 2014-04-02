package ast.statement;

import ast.visitors.StatementVisitor;

public class Block extends Statement{
	
	private final StatementList statements;

	public Block(StatementList statements) {
		this.statements = statements;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public StatementList getStatements() {
		return statements;
	}

}
