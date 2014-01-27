package org.uva.sea.ql.eval;

public class Undefined extends Value {
	public static final Undefined UNDEF = new Undefined();
	
	private Undefined() {
	}
	
	@Override
	public Object getValue() {
		return null;
	}

	public Value add(Value arg) {
		return UNDEF;
	}

	public Value pos() {
		return UNDEF;
	}
	
	public Value div(Value arg) {
		return UNDEF;
	}

	public Value mul(Value arg) {
		return UNDEF;
	}

	public Value sub(Value arg) {
		return UNDEF;
	}

	public Value and(Value arg) {
		return UNDEF;
	}


	public Value geq(Value arg) {
		return UNDEF;
	}

	public Value gt(Value arg) {
		return UNDEF;
	}

	public Value leq(Value arg) {
		return UNDEF;
	}

	public Value lt(Value arg) {
		return UNDEF;
	}

	
	public Value neg() {
		return UNDEF;
	}

	public Value neq(Value arg) {
		return UNDEF;
	}

	public Value eq(Value arg) {
		return UNDEF;
	}

	
	public Value not() {
		return UNDEF;
	}

	public Value or(Value arg) {
		return UNDEF;
	}

	@Override
	public Value addInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value mulInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value subInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value divInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value gtInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value geqInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value ltInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value leqInt(Int arg) {
		return UNDEF;
	}
	
	@Override
	public Value andBool(Bool arg) {
		return UNDEF;
	}
	

	@Override
	public Value orBool(Bool arg) {
		return UNDEF;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean isDefined() {
		return false;
	}
	

	
}
