package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Decimal;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class DecimalLiteral extends NumberLiteral<Float> {
	
	public DecimalLiteral(Float value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Decimal();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
