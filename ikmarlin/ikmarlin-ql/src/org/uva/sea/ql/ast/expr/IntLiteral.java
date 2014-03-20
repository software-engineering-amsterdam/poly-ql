package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitor;

public class IntLiteral extends NumberLiteral {
	
	private int value;
	
	public IntLiteral(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	@Override
	public Type hasType() {
		return new Int();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ev) {
		return ev.visit(this);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
