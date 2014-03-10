package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.StatementVisitor;

//TODO: MAKE THIS ITERABLE?
public class Questions extends Statement{

	private List<Statement> questions = new ArrayList<Statement>();
	
	public Questions(Statement single) {

		questions.add(single);
		
	}
	
	public Questions(Statement single, Questions multiple) {
		
		this.questions.add(single);
		this.questions.addAll(multiple.questions);
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public List<Statement> getQuestions(){
		return this.questions;
	}
	

}
