package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class IntLiteral extends NumberLiteral<Integer> {
	
	public IntLiteral(Integer value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Int();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
