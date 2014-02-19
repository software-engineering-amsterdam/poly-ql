package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;

public class If extends Statement{

	private Expression conditional;
	private QuestionSet questionset;
	
	public If(Expression expr, QuestionSet questionset) {
		
		this.conditional = expr;
		this.questionset = questionset;
	
		// TODO Auto-generated constructor stub
	}
	
	public Expression getConditional(){
		return this.conditional;
	}
	
	public QuestionSet getQuestionSet(){
		return this.questionset;
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}
