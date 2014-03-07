package org.uva.sea.ql.evaluate;

import org.uva.sea.ql.ast.type.Type;

public abstract class Value {
	
	public abstract Object getValue();

	public Value add(Value value){
		return null; 
	}

	public Value addInteger(IntegerValue integerValue) {
		return null;
	}

	public Value sub(Value value) {
		return null;
	}

	public Value subInteger(IntegerValue integerValue) {
		return null;
	}

	public Value div(Value value) {
		return null;
	}

	public Value divInteger(IntegerValue integerValue) {
		return null;
	}

	public Value mul(Value value) {
		return null;
	}
	public Value mulInteger(IntegerValue integerValue) {
		return null;
	}

	public Value neg() {
		return null;
	}

	public Value pos() {
		return null;
	}

	public Value eq(Value value) {
		return null;
	}
	
	public Value eqInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value leq(Value value){
		return null;
	}
	
	public Value leqInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value gt(Value value){
		return null;
	}
	
	public Value gtInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value geq(Value value){
		return null;
	}
	
	public Value geqInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value lt(Value value){
		return null;
	}
	
	public Value ltInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value neq(Value value){
		return null;
	}
	
	public Value neqInteger(IntegerValue integerValue) {
		return null;
	}
	
	public Value and(Value value){
		return null;
	}
	
	public Value andBoolean(BooleanValue booleanValue) {
		return null;
	}
	
	public Value or(Value value){
		return null;
	}
	
	public Value orBoolean(BooleanValue booleanValue) {
		return null;
	}
	
	public Value not(){
		return null;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Type) {
	        return getValue().equals(((Value) other).getValue());
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return getValue().hashCode();
	}

}
