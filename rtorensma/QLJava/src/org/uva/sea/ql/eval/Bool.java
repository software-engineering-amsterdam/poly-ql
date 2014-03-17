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
	
	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}
	
	@Override
	public Value not() {
		return new Bool(!getValue());
	}
	
	/*
	 * NB: below the arguments are reversed because of double dispatch
	 *     but this doesn't really matter with these operators.
	 */
	
	@Override
	public Value andBool(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}
	
	@Override
	public Value orBool(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}
}
