package ast.statement;

import ast.Visitor;
import ast.expr.Identifier;

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
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
