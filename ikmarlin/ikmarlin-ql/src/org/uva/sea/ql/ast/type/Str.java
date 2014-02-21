package org.uva.sea.ql.ast.type;

public class Str extends Type {
	
	@Override
	public boolean isCompatibleWith(Str t) {
		return true;
	}

}
