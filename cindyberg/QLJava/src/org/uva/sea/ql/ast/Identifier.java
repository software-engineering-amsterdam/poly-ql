package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class Identifier extends Expression {

	String name;
	
	public Identifier(String name) {
		
		this.name = name;

	}

	@Override
	public void accept(IOperatorVisitor visitor) {
		//visitor.visit(this);
		
	}

}
