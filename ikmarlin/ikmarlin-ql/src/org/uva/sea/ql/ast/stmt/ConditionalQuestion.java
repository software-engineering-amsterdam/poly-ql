package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class ConditionalQuestion extends Stmt {
	
	private Expr condition;
	private Block body;

	public ConditionalQuestion(Expr condition, Block body) {
		this.condition = condition;
		this.body = body;
	}
	
	public Expr getCondition() {
		return condition;
	}

	public void setCondition(Expr condition) {
		this.condition = condition;
	}

	public Block getBody() {
		return body;
	}

	public void setBody(Block body) {
		this.body = body;
	}

	@Override
	public String toString(){
		String question = "[";
		question += getCondition().toString();
		question += getBody().toString();
		question += "]";
		return question;
	}
}
