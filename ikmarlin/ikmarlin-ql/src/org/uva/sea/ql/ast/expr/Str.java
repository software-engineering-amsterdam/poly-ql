package org.uva.sea.ql.ast.expr;

public class Str extends Expr {
	private String value;
	
	public Str(String value) {
		this.value = value;
	}
}
