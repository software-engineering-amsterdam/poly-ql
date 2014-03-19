package org.uva.sea.ql.evaluate;

public class UndefinedValue extends Value {

	public static final UndefinedValue UNDEF = new UndefinedValue();
	
	UndefinedValue(){}
	
	@Override
	public Object getValue() {
		return null;
	}
}
