package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.checker.ExprVisitor;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public Type hasType() {
		return new Bool();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	public String toString(){
		return "!"+this.getArg().toString();
	}

}
