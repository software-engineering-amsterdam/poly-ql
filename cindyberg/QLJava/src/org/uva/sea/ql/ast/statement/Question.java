package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement  {

	private Identifier name;
	private StringLiteral label;
	private Type type;
	
	
	public Question(Identifier questionname, StringLiteral label,
			Type type) {
		
		this.name = questionname;
		this.label = label;
		this.type = type;
		
		
	}
	
	public Identifier getName(){
		return this.name;
	}
	
	public StringLiteral getLabel(){
		return this.label;
	}
	
	public Type getType(){
		return this.type;
	}


	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}


}
