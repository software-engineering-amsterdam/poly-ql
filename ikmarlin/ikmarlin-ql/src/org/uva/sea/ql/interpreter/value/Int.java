package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;


public class Int extends Num<Integer> {
	
	public Int(){
		this.value = 0;
	}
	
	public Int(int value){
		this.value = value;
	}

	@Override
	public Value<?> add(Value<?> value) {
		return value.intAdd(this);
	}

	@Override
	public Value<?> sub(Value<?> value) {
		return value.intSub(this);
	}

	@Override
	public Value<?> mul(Value<?> value) {
		return value.intMul(this);
	}

	@Override
	public Value<?> div(Value<?> value) {
		return value.intDiv(this);
	}
	
	@Override
	public Value<?> pos() {
		return this;
	}
	
	@Override
	public Value<?> neg() {
		return new Int(value * -1);
	}

	@Override
	public Value<?> lt(Value<?> value) {
		return value.intLt(this);
	}
	
	@Override
	public Value<?> leq(Value<?> value) {
		return value.intLeq(this);
	}
	
	@Override
	public Value<?> gt(Value<?> value) {
		return value.intGt(this);
	}
	
	@Override
	public Value<?> geq(Value<?> value) {
		return value.intGeq(this);
	}
	
	@Override
	public Value<?> eq(Value<?> value) {
		return value.intEq(this);
	}
	
	@Override
	public Value<?> neq(Value<?> value) {
		return value.intNeq(this);
	}
	
	@Override
	protected Value<?> intAdd(Int leftValue) {
		return new Int(leftValue.getValue() + value);
	}

	@Override
	protected Value<?> intSub(Int leftValue) {
		return new Int(leftValue.getValue() - value);
	}

	@Override
	protected Value<?> intMul(Int leftValue) {
		return new Int(leftValue.getValue() * value);
	}

	@Override
	protected Value<?> intDiv(Int leftValue) {
		return new Int(leftValue.getValue() / value);
	}

	@Override
	protected Value<?> intLt(Int leftValue) {
		return new Bool(leftValue.getValue() < value);
	}
	
	@Override
	protected Value<?> intLeq(Int leftValue) {
		return new Bool(leftValue.getValue() <= value);
	}
	
	@Override
	protected Value<?> intGt(Int leftValue) {
		return new Bool(leftValue.getValue() > value);
	}
	
	@Override
	protected Value<?> intGeq(Int leftValue) {
		return new Bool(leftValue.getValue() >= value);
	}
	
	@Override
	protected Value<?> intEq(Int leftValue) {
		return new Bool(leftValue.getValue().equals(value));
	}

	@Override
	protected Value<?> intNeq(Int leftValue) {
		return new Bool(!leftValue.getValue().equals(value));
	}


	@Override
	public Value<?> parse(Type type) {
		return type.hasValue().parse(this);
	}

	@Override
	protected Value<?> parse(Int value) {
		return value;
	}

	@Override
	protected Value<?> parse(Undefined value) {
		return new Int();
	}

}
