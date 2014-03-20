package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;


public class Undefined extends Value<Void> {
	
	public Undefined(){
		this.value = null;
	}

	public Value<?> parse(Type type){
		return type.hasValue().parse(this);
	}
	
	private Value<?> defaultReturn(){
		return this;
	}

	public Value<?> add(Value<?> value) {
		return defaultReturn();
	}

	protected Value<?> intAdd(Int value) {
		return defaultReturn();
	}

	public Value<?> sub(Value<?> value) {
		return defaultReturn();
	}

	protected Value<?> intSub(Int leftValue) {
		return defaultReturn();
	}

	public Value<?> mul(Value<?> value) {
		return defaultReturn();
	}

	protected Value<?> intMul(Int leftValue) {
		return defaultReturn();
	}

	public Value<?> div(Value<?> value) {
		return defaultReturn();
	}

	protected Value<?> intDiv(Int leftValue) {
		return defaultReturn();
	}

	public Value<?> pos() {
		return defaultReturn();
	}

	public Value<?> neg() {
		return defaultReturn();
	}

	public Value<?> and(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> or(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> not() {
		return defaultReturn();
	}

	protected Value<?> boolAnd(Bool leftValue) {
		return defaultReturn();
	}

	protected Value<?> boolOr(Bool leftValue) {
		return defaultReturn();
	}

	public Value<?> lt(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> leq(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> gt(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> geq(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> eq(Value<?> value) {
		return defaultReturn();
	}

	public Value<?> neq(Value<?> value) {
		return defaultReturn();
	}

	protected Value<?> intLt(Int leftValue) {
		return defaultReturn();
	}

	protected Value<?> intLeq(Int leftValue) {
		return defaultReturn();
	}

	protected Value<?> intGt(Int leftValue) {
		return defaultReturn();
	}

	protected Value<?> intGeq(Int leftValue) {
		return defaultReturn();
	}

	protected Value<?> intEq(Int value) {
		return defaultReturn();
	}

	protected Value<?> intNeq(Int value) {
		return defaultReturn();
	}

	protected Value<?> parse(Undefined value){
		return defaultReturn();
	}

	protected Value<?> parse(Bool value){
		return defaultReturn();
	}

	protected Value<?> parse(Str value){
		return defaultReturn();
	}

	protected Value<?> parse(Int value){
		return defaultReturn();
	}

}
