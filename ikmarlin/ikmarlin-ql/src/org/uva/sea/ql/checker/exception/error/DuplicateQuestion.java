package org.uva.sea.ql.checker.exception.error;

public class DuplicateQuestion extends Error {
	
	private static final long serialVersionUID = 1L;
	
	private String ident;
	
	public DuplicateQuestion(String ident){
		this.ident = ident;
	}

	public String getMessage() {
		return "the question << "+ident+" >> has been defined with multiple types";
	}

}
