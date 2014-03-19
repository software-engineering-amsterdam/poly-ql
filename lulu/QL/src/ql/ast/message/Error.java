package ql.ast.message;

public class Error {

	private final String text;
	
	public Error(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
