package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class BoolLiteral extends Literal<Boolean> {
	
	public BoolLiteral(Boolean value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Bool();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
