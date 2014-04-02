package ast.statement;

import ast.expr.Identifier;
import ast.visitors.StatementVisitor;

public class Form extends Block{
	
	private final Identifier id;

	public Form(Identifier id, StatementList statements) {
		super(statements);
		this.id = id;
	}

	public Identifier getId() {
		return id;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
