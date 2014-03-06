package org.uva.sea.ql.evaluate;

public class BooleanValue extends Value {

	private final Boolean value;
	
	public BooleanValue(Boolean value){
		this.value = value;
	}
	
	@Override
	public Boolean getValue(){
		return value;
	}
	
	@Override
	public Value and(Value value){
		return value.andBoolean(this);
		
	}
	
	@Override
	public Value andBoolean(BooleanValue value){
		return new BooleanValue(value.getValue() && this.getValue());
	}
	
	@Override
	public Value or(Value value){
		return value.orBoolean(this);
	}
	
	@Override
	public Value orBoolean(BooleanValue value){
		return new BooleanValue(value.getValue() || this.getValue());
	} 
	
	@Override
	public Value not(){
		return new BooleanValue(!this.getValue());
	}
	
}
