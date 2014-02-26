package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class BoolLiteral extends Literal<Boolean> {
	
	public BoolLiteral(Boolean value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Bool();
	}

	@Override
	public <T> T accept(ExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
