package ast.form;

import ast.Visitor;

public class Block extends Statement{
	private final StatementList statements;

	public Block(StatementList statements) {
		
		this.statements = statements;
	}

	public StatementList getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
