package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement  {

	private final Identifier name;
	private final StringLiteral label;
	private final Type type;
		
	public Question(Identifier questionname, StringLiteral label,
			Type type) {	
		this.name = questionname;
		this.label = label;
		this.type = type;
	
	}
	
	public Identifier getIdentifier(){
		return this.name;
	}
	
	public StringLiteral getLabel(){
		return this.label;
	}
	
	public Type getType(){
		return this.type;
	}


	public void accept(StatementVisitor visitor) {
		visitor.visit(this);	
	}
}
