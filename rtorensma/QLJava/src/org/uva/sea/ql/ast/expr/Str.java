package org.uva.sea.ql.ast.expr;


public class Str extends Expr {
	private final String value;

	public Str(String value) {
		this.value = value.substring(1, value.length() - 1);
	}
	
	public String getValue() {
		return value;
	}
}
