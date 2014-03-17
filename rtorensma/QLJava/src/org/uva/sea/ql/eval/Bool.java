package org.uva.sea.ql.eval;

public class Bool extends Value {
	private final Boolean value;
	
	public Bool(Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}
}
