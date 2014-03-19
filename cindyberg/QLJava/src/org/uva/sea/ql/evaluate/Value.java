package org.uva.sea.ql.evaluate;

import org.uva.sea.ql.ast.type.Type;

public abstract class Value {
	
	public abstract Object getValue();

	public Value add(Value value){
		throw new UnsupportedOperationException() ;
	}

	public Value addInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value subInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value divInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value value) {
		throw new UnsupportedOperationException();
	}
	public Value mulInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value value) {
		throw new UnsupportedOperationException();
	}
	
	public Value eqInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value leqInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value gtInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value geqInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value ltInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value neqInteger(IntegerValue integerValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value and(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value andBoolean(BooleanValue booleanValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Value value){
		throw new UnsupportedOperationException();
	}
	
	public Value orBoolean(BooleanValue booleanValue) {
		throw new UnsupportedOperationException();
	}
	
	public Value not(){
		throw new UnsupportedOperationException();
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
	
	public boolean isDefined(){
		return (this != UndefinedValue.UNDEF);
	}

}
