package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.IVisitor;

public class IfElse extends Statement {

	private Expression conditional;
	private QuestionSet questionsetIf;
	private QuestionSet questionsetElse;
	
	public IfElse(Expression expr, QuestionSet questionsetIf, QuestionSet questionsetElse) {
		this.conditional = expr;
		this.questionsetIf = questionsetIf;
		this.questionsetElse = questionsetElse;
	}
	
	public Expression getConditional(){
		return this.conditional;
	}

	public QuestionSet getIfQuestionSet(){
		return this.questionsetIf;
	}
	
	public QuestionSet getElseQuestionSet(){
		return this.questionsetElse;
	}
	
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

}
