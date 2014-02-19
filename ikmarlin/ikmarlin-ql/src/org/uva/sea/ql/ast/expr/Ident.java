package org.uva.sea.ql.ast.expr;

public class Ident extends Expr {
	private String name;
	
	public Ident(String name) {
		this.name = name;
	}
}
