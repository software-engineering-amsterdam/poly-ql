package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.checker.ExprVisitor;

public class LEq extends Binary {

	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type hasType() {
		return new Bool();
	}
	
	@Override
	public void accept(ExprVisitor ev) {
		ev.visit(this);
	}

	@Override
	public String toString(){
		return this.getLhs().toString()+" <= "+this.getRhs().toString();
	}

}
