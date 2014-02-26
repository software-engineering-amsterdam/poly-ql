package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class StrLiteral extends Literal<String> {
	
	public StrLiteral(String value){
		super.setValue(value);
	}

	@Override
	public Type hasType() {
		return new Str();
	}

	@Override
	public <T> T accept(ExprVisitor<T> ev) {
		return ev.visit(this);
	}

}
