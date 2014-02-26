package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.checker.ExprVisitor;

public class Pos extends Unary {

	public Pos(Expr arg) {
		super(arg);
	}

	@Override
	public Type hasType() {
		return new Number();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	public String toString(){
		return "+"+this.getArg().toString();
	}

}
