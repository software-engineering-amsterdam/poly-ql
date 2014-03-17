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
	
	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
	}
	
	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}
	
	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}
	
	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}
	
	@Override
	public Value geq(Value arg) {
		return arg.geqInt(this);
	}
	
	@Override
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}
	
	@Override
	public Value leq(Value arg) {
		return arg.leqInt(this);
	}
	
	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}
	
	/*
	 * NB: below the arguments are reversed because of double dispatch.
	 */
	
	@Override
	public Value addInt(Int arg) {
		return new Int(arg.getValue() + this.getValue());
	}
	
	@Override
	public Value divInt(Int arg) {
		return new Int(arg.getValue() / this.getValue());
	}

	@Override
	public Value mulInt(Int arg) {
		return new Int(arg.getValue() * this.getValue());
	}

	@Override
	public Value subInt(Int arg) {
		return new Int(arg.getValue() - this.getValue());
	}
	
	@Override
	public Value geqInt(Int arg) {
		return new Bool(arg.getValue() >= this.getValue());
	}
	
	@Override
	public Value gtInt(Int arg) {
		return new Bool(arg.getValue() > this.getValue());
	}
	
	@Override
	public Value leqInt(Int arg) {
		return new Bool(arg.getValue() <= this.getValue());
	}
	
	@Override
	public Value ltInt(Int arg) {
		return new Bool(arg.getValue() < this.getValue());
	}
	
	@Override
	public Value pos() {
		return this;
	}
	
	@Override
	public Value neg() {
		return new Int(- this.getValue());
	}
}
