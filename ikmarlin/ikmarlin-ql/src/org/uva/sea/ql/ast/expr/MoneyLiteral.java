package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class MoneyLiteral extends NumberLiteral<Float> {
	
	public MoneyLiteral(Float value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Money();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
