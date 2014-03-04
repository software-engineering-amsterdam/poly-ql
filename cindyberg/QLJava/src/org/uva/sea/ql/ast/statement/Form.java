package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.StatementVisitor;

public class Form extends Statement{

	private final Identifier name;
	private final QuestionSet questionset;
	
	public Form(Identifier formname, QuestionSet questionset) {
		
		this.name = formname;
		this.questionset = questionset;
	}

	public Identifier getFormName(){
		return name;
	}
	
	public QuestionSet getQuestionSet(){
		return questionset;
	}
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
