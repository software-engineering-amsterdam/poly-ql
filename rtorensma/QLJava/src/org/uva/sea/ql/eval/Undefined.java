package org.uva.sea.ql.eval;

public class Undefined extends Value {

	@Override
	public Object getValue() {
		return null;
	}
	
	public Value add(Value arg) {
		return new Undefined();
	}
	
	public Value div(Value arg) {
		return new Undefined();
	}

	public Value mul(Value arg) {
		return new Undefined();
	}

	public Value sub(Value arg) {
		return new Undefined();
	}
	
	public Value geq(Value arg) {
		return new Undefined();
	}

	public Value gt(Value arg) {
		return new Undefined();
	}

	public Value leq(Value arg) {
		return new Undefined();
	}

	public Value lt(Value arg) {
		return new Undefined();
	}
	
	public Value pos() {
		return new Undefined();
	}
	
	public Value neg() {
		return new Undefined();
	}
	
	public Value and(Value arg) {
		return new Undefined();
	}
	
	public Value or(Value arg) {
		return new Undefined();
	}
	
	public Value eq(Value arg) {
		return new Undefined();
	}
	
	public Value neq(Value arg) {
		return new Undefined();
	}
	
	public Value not() {
		return new Undefined();
	}
	
	
	
	@Override
	public Value addInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value divInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value mulInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value subInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value geqInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value gtInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value leqInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value ltInt(Int arg) {
		return new Undefined();
	}
	
	@Override
	public Value andBool(Bool arg) {
		return new Undefined();
	}

	@Override
	public Value orBool(Bool arg) {
		return new Undefined();
	}
}
