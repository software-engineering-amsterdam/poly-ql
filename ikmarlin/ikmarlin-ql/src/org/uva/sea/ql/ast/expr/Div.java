package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.checker.ExprVisitor;

public class Div extends Binary {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type hasType() {
		return new Number();
	}

	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	@Override
	public String toString(){
		return this.getLhs().toString()+" / "+this.getRhs().toString();
	}

}
