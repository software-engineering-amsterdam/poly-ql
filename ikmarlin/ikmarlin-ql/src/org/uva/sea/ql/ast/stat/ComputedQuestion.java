package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public class ComputedQuestion extends Question {
	
	private Expr computation;

	public ComputedQuestion(Ident ident, String label, Expr type, Expr computation) {
		super(ident, label, type);
		this.computation = computation;
	}

}
