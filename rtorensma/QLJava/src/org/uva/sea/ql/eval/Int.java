package org.uva.sea.ql.eval;

public class Int extends Value {
	private final Integer value;
	
	public Int(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}
}
