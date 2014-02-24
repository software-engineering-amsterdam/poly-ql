package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public abstract class Question extends Stmt {
	
	private Ident ident;
	private String label;
	private Expr type;
	
	public Question(Ident ident, String label, Expr type){
		this.setIdent(ident);
		this.label = label;
		this.type = type;
	}

	public Ident getIdent() {
		return ident;
	}

	public void setIdent(Ident ident) {
		this.ident = ident;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Expr getType() {
		return type;
	}

	public void setType(Expr type) {
		this.type = type;
	}
	
}
