package org.uva.sea.ql.ast.expr;

public class Bool extends Expr {
	private boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
}
