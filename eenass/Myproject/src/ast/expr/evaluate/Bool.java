package ast.expr.evaluate;

public class Bool extends Value{
	
	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}
	
	private boolean getValue() {
		return value;
	}


	@Override
	public Value and(Value val){
		return val.andBool(this);
	}
	
	@Override
	protected Value andBool(Bool val){
		return new Bool(val.getValue() && getValue());
	}
	
	
	@Override
	public Value or(Value val){
		return val.andBool(this);
	}
	
	@Override
	protected Value orBool(Bool val){
		return new Bool(val.getValue() || getValue());
	}
	
	@Override
	public Value neq(Value val){
		return val.neqBool(this);
	}
	
	@Override
	protected Value neqBool(Bool val){
		return new Bool(val.getValue() != getValue());
	}
	
	@Override
	public Value eq(Value val){
		return val.eqBool(this);
	}
	
	@Override
	protected Value eqBool(Bool val){
		return new Bool(val.getValue() == getValue());
	}
	
	@Override
	public Value not(){
		return new Bool(!getValue());
	}
}
