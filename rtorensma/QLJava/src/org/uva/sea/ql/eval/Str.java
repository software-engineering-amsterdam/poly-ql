package org.uva.sea.ql.eval;

public class Str extends Value {
	private final String value;
	
	public Str(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
