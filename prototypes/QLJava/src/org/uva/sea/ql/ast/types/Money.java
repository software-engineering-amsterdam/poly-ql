package org.uva.sea.ql.ast.types;

public class Money extends Numeric {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Money;
	}
	
	@Override
	public String toString() {
		return "money";
	}

}
