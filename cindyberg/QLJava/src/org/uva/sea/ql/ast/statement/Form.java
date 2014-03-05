package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;

public class Form extends Statement{

	private final Identifier name;
	private final Questions body;
	
	public Form(Identifier formname, Questions body) {		
		this.name = formname;
		this.body = body;
	}

	public Identifier getName(){
		return name;
	}
	
	public Questions getBody(){
		return body;
	}
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}
