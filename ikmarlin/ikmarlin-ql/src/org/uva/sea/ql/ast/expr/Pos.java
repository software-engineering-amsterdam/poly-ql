package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class Pos extends Unary {

	public Pos(Expr arg) {
		super(arg);
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

	@Override
	public Type hasType() {
		return new Number();
	}

	public String toString(){
		return "+"+this.getArg().toString();
	}

}
