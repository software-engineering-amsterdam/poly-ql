package ast.form;

import expr.Ident;
import ast.Visitor;

public class Form extends Block{

	private final Ident id;
	
	public Form(Ident id,StatementList statements) {
		super(statements);
		this.id =id;
		
	}

	public Ident getId() {
		return id;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
