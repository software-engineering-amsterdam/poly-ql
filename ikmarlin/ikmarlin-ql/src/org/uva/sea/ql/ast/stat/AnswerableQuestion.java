package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public class AnswerableQuestion extends Question {

	public AnswerableQuestion(Ident ident, String label, Expr type) {
		super(ident, label, type);
	}
	
}
