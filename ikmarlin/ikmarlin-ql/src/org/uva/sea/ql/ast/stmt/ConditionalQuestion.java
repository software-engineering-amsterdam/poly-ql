package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.checker.StmtVisitor;

public class ConditionalQuestion extends Stmt {
	
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
	public void accept(StmtVisitor sv) {
		sv.visit(this);
	}

}
