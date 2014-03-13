package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Ident;

public class UndefinedQuestion extends Error {
	
	private Ident ident;
	
	public UndefinedQuestion(Ident ident){
		this.ident = ident;
	}

	public String getMessage() {
		return "the question << " + ident.getName() + " >> is undefined";
	}

}
