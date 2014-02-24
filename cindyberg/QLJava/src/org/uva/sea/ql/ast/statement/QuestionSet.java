package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.StatementVisitor;


public class QuestionSet extends Statement{

	private List<Statement> questions = new ArrayList<Statement>();
	
	public QuestionSet(Statement single) {

		questions.add(single);
		
	}
	
	public QuestionSet(Statement single, QuestionSet multiple) {
		
		this.questions.add(single);
		this.questions.addAll(multiple.questions);
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public List<Statement> getQuestionset(){
		return this.questions;
	}
	

}
