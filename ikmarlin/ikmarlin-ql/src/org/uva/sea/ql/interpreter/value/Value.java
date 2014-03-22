package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;

public abstract class Value<T> {
	
	private String atError = "at: "+this;

	protected T value;

	public T getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(value);
	}

	public Value<?> add(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intAdd(Int value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> sub(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intSub(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> mul(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intMul(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> div(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intDiv(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> pos() {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> neg() {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> and(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> or(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> not() {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> boolAnd(Bool leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> boolOr(Bool leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> lt(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> leq(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> gt(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> geq(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> eq(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> neq(Value<?> value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intLt(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intLeq(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intGt(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intGeq(Int leftValue) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intEq(Int value) {
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> intNeq(Int value) {
		throw new UnsupportedOperationException(atError);
	}

	public Value<?> parse(Type type){
		throw new UnsupportedOperationException(this+" cannot be parsed");
	}

	protected Value<?> parse(Undefined value){
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> parse(Bool value){
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> parse(Str value){
		throw new UnsupportedOperationException(atError);
	}

	protected Value<?> parse(Int value){
		throw new UnsupportedOperationException(atError);
	}

}
