package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public abstract class Question extends Statement {
	private Ident ident;
	private String label;
	private Expr type;
	
	public Question(Ident ident, String label){
		this.ident = ident;
		this.label = label;
	}
}
