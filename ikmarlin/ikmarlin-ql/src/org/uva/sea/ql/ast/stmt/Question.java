package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class Question extends Stmt {
	
	private Ident ident;
	private String label;
	private Type type;
	
	public Question(Ident ident, String label, Type type){
		this.setIdent(ident);
		this.label = label.replaceAll("\\"+"\"", "");
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		String question = "[";
		question += getIdent().getName();
		question += " = ";
		question += getType().toString();
		question += "]";
		return question;
	}
}
