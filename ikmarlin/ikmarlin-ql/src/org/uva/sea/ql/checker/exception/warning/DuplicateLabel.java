package org.uva.sea.ql.checker.exception.warning;

public class DuplicateLabel extends DuplicateWarning {
	
	private static final long serialVersionUID = 1L;
	
	private String ident;
	
	public DuplicateLabel(String ident2){
		this.ident = ident2;
	}

	public String getMessage() {
		return "WARNING: the question << "+ident+" >> has been defined multiple times";
	}

}
