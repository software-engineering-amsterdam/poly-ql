package org.uva.sea.ql.ast.type;

public class Error extends Type {
	
	private String error;
	
	public Error(String message){
		this.setError(message);
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithError();
	}
	
	@Override
	public String toString() {
		return getError();
	}

}
