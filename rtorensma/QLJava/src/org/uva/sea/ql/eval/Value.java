package org.uva.sea.ql.eval;

public abstract class Value {
	public abstract Object getValue();
	
	@Override
	public boolean equals(Object obj) {
		if (getValue() == null) {
			// Value = Undefined
			return false;
		}
		return this.getValue().equals(((Value)obj).getValue());
	}
	
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value eq(Value arg) {
		return new Bool(arg.equals(this));
	}

	public Value neq(Value arg) {
		return new Bool(!arg.equals(this));
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * These methods are called in the Value subclasses
	 * to do the evaluation.
	 */
	
	public Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value gtInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value leqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value ltInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
}
