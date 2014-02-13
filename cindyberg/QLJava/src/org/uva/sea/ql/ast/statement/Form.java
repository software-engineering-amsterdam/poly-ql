package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Identifier;

public class Form implements ASTNode{

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
	
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
