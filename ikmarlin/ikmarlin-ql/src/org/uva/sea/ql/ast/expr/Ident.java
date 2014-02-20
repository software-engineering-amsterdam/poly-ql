package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Ident extends Expr {
	private String name;
	
	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Type hasType() {
		return null;
	}
	
	@Override
	public void accept(ExprVisitor ev) {
		ev.visit(this);
	}
	
	@Override
	public String toString(){
		return getName();
	}

}
