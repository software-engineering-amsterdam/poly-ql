package org.uva.sea.ql.eval;

public abstract class Value {
	
	/* int ops */
	
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

	/* Bool ops */
	
	public Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}


	
	
	/* generic ones. */
	
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
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

	public Value and(Value arg) {
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

	
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value neq(Value arg) {
		return new Bool(!arg.equals(this));
	}

	public Value eq(Value arg) {
		return new Bool(arg.equals(this));
	}

	
	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public abstract Object getValue();
	
	@Override
	public boolean equals(Object obj) {
		if (getValue() == null) {
			// NB: even if both values are Undefined, still return false
			// (iow: undefined is not equal to anything, not even itself).
			return false;
		}
		return getValue().equals(((Value)obj).getValue());
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
	

	public boolean isDefined() {
		return true;
	}
	

}
