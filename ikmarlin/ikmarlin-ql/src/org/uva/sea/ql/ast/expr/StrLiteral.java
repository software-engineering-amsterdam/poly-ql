package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class StrLiteral extends Literal {
	
	private String value;
	
	public StrLiteral(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
	public Type hasType() {
		return new Str();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

	@Override
	public String toString() {
		return value;
	}
	
}
