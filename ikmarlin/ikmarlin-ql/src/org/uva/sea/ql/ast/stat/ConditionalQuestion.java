package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public class ConditionalQuestion extends Statement {
	
	private Expr condition;
	private Block body;

	public ConditionalQuestion(Expr condition, Block body) {
		this.condition = condition;
		this.body = body;
	}
}
