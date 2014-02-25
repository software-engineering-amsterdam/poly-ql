package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.checker.ExprVisitor;

public class GEq extends Binary {

	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type hasType() {
		return new Bool();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	@Override
	public String toString(){
		return this.getLhs().toString()+" >= "+this.getRhs().toString();
	}

}
