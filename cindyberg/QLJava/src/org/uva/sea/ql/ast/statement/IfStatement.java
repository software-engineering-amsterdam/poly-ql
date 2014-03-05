package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;

public class IfStatement extends Statement{

	private final Expression conditional;
	private final QuestionSet questionset;
	
	public IfStatement(Expression expr, QuestionSet questionset) {
		
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
