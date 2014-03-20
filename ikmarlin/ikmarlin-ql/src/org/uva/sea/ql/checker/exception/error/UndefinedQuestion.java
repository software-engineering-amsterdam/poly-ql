package org.uva.sea.ql.checker.exception.error;

import org.uva.sea.ql.ast.expr.Ident;

public class UndefinedQuestion extends Error {
	
	private static final long serialVersionUID = 1L;
	
	private Ident ident;
	
	public UndefinedQuestion(Ident ident){
		this.ident = ident;
	}

	public String getMessage() {
		return "the question << " + ident.getName() + " >> is undefined";
	}

}
