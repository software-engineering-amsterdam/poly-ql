package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.Identifier;

public class Form extends Statement{

	private Identifier name;
	private QuestionSet questionset;
	
	public Form(Identifier formname, QuestionSet questionset) {
		
		this.name = formname;
		this.questionset = questionset;
	}

	public Identifier getFormName(){
		return this.name;
	}
	
	public QuestionSet getQuestionSet(){
		return this.questionset;
	}
	
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

}
