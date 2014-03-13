package org.uva.sea.ql.checker.error;

public class DuplicateQuestion extends Error {
	
	private String ident;
	
	public DuplicateQuestion(String ident){
		this.ident = ident;
	}

	public String getMessage() {
		return "the question << "+ident+" >> has been defined with multiple types";
	}

}
