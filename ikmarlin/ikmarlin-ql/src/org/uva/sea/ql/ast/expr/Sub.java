package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.checker.ExprVisitor;

public class Sub extends Binary {

	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type hasType() {
		return new Number();
	}

	@Override
	public void accept(ExprVisitor ev) {
		ev.visit(this);
	}

	@Override
	public String toString(){
		return this.getLhs().toString()+" - "+this.getRhs().toString();
	}

}