package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;

public class IfElseStatement extends Statement {

	private final Expression conditional;
	private final QuestionSet questionsetIf;
	private final QuestionSet questionsetElse;
	
	public IfElseStatement(Expression expr, QuestionSet questionsetIf, QuestionSet questionsetElse) {
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
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
