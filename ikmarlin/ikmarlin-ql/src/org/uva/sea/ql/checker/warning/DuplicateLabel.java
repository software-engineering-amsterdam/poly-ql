package org.uva.sea.ql.checker.warning;

public class DuplicateLabel extends DuplicateWarning {
	
	
	private String ident;
	
	public DuplicateLabel(String ident2){
		this.ident = ident2;
	}

	public String getMessage() {
		return "WARNING: the question << "+ident+" >> has been defined multiple times";
	}

}
