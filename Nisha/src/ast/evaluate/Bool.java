package ast.evaluate;

public class Bool extends Value{
	
	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
	
	
	@Override
	public Value and(Value obj)
	{
		return obj.andBool(this);
	}
	@Override
	public Value andBool(Bool obj)
	{
		return new Bool(obj.getValue() && getValue());
	}
	@Override
	public Value or(Value obj)
	{
		return obj.orBool(this);
	}
	@Override
	public Value orBool(Bool obj)
	{
		return new Bool(obj.getValue() || getValue());
	}
	
	@Override
	public Value eq(Value obj) {
		return obj.eqBool(this);
	}
	@Override
	protected Value eqBool(Bool obj) {
		return new Bool(obj.getValue() == getValue());
	}
	
	@Override
	public Value neq(Value obj) {
		return obj.neqBool(this);
	}
	@Override
	protected Value neqBool(Bool obj) {
		return new Bool(obj.getValue() != getValue());
	}
	@Override
	public Value not() {
		return new Bool(!getValue());
	}
	

}
	