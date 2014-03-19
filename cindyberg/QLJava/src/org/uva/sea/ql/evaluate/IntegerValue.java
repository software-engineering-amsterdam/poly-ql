package org.uva.sea.ql.evaluate;

public class IntegerValue extends Value{

	private final int value;
	
	public IntegerValue(Integer value){
		this.value = value;
	}
	
	public Integer getValue(){
		return this.value;
	}
	
	@Override
	public Value add(Value value){
		return value.addInteger(this);
	}
	
	@Override
	public Value addInteger(IntegerValue value){
		return new IntegerValue(value.getValue() + this.getValue());
	}
	
	@Override 
	public Value sub(Value value){
		return value.subInteger(this);
	}
	
	@Override
	public Value subInteger(IntegerValue value){
		return new IntegerValue(value.getValue() - this.getValue());
	}
	
	
	@Override 
	public Value div(Value value){
		return value.divInteger(this);
	}
	
	@Override
	public Value divInteger(IntegerValue value){
		return new IntegerValue(value.getValue() / this.getValue());
	}
	
	@Override
	public Value mul(Value value){
		return value.mulInteger(this);
	}
	
	@Override
	public Value mulInteger(IntegerValue value){
		return new IntegerValue(value.getValue() * this.getValue());
	}
	
	@Override
	public Value neg(){
		return new IntegerValue(-this.getValue());
	}
	
	@Override
	public Value pos(){
		return new IntegerValue(this.getValue());
	}
	
	@Override
	public Value lt(Value value){
		return value.ltInteger(this);
	}
	
	@Override
	public Value ltInteger(IntegerValue value){
		return new BooleanValue(value.getValue() < this.getValue());
	}
	
	@Override
	public Value gt(Value value){
		return value.gtInteger(this);
	}
	
	@Override
	public Value gtInteger(IntegerValue value){
		return new BooleanValue(value.getValue() > this.getValue());
	}
	
	@Override
	public Value eq(Value value) {
		return value.eqInteger(this);
	}
	
	@Override
	public Value eqInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() == this.getValue());
	}
	
	@Override
	public Value leq(Value value){
		return value.leqInteger(this);
	}
	
	@Override
	public Value leqInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() <= this.getValue());
	}
	
	@Override
	public Value geq(Value value){
		return value.geqInteger(this);

	}
	
	@Override
	public Value geqInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() >= this.getValue());
	}
	
	@Override
	public Value neq(Value value){
		return value.neqInteger(this);
	}
	
	@Override
	public Value neqInteger(IntegerValue value) {
		return new BooleanValue(value.getValue() != this.getValue());
	}
}
