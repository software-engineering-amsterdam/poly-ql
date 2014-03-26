package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;


public class Bool extends Value<Boolean> {
	
	public Bool(){
		this.value = false;
	}
	
	public Bool(boolean value){
		this.value = value;
	}
	
	@Override
	public Value<?> and(Value<?> value) {
		return value.boolAnd(this);
	}
	
	@Override
	public Value<?> or(Value<?> value) {
		return value.boolOr(this);
	}
	
	@Override
	public Value<?> not() {
		return new Bool(!value);
	}
	
	@Override
	protected Value<?> boolAnd(Bool leftValue) {
		return new Bool(leftValue.getValue() && value);
	}
	
	@Override
	protected Value<?> boolOr(Bool leftValue) {
		return new Bool(leftValue.getValue() || value);
	}
	
	@Override
	public Value<?> parse(Type type) {
		return type.hasValue().parse(this);
	}
	
	@Override
	protected Value<?> parse(Bool value) {
		return value;
	}

	@Override
	protected Value<?> parse(Undefined value) {
		return new Bool();
	}

}