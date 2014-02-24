package org.uva.sea.ql.ast.type;

public class Number extends Type {
	
	@Override
	public boolean isCompatibleWith(Number t) {
		return true;
	}

}
