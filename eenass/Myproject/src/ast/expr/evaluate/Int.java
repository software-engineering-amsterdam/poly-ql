package ast.expr.evaluate;

public class Int extends Value{
	
	private final Integer value;
	
	public Int(Integer value) {
		this.value = value;		
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public Value add(Value val){
		return val.addInt(this);
	}
	
	@Override
	protected Value addInt(Int val){
		return new Int(val.getValue() + getValue());
	}
	
	@Override
	public Value sub(Value val){
		return val.addInt(this);
	}
	
	@Override
	protected Value subInt(Int val){
		return new Int(val.getValue() - getValue());
	}
	
	@Override
	public Value div(Value val){
		return val.addInt(this);
	}
	
	@Override
	protected Value divInt(Int val){
		return new Int(val.getValue() / getValue());
	}
	
	@Override
	public Value mul(Value val){
		return val.addInt(this);
	}
	
	@Override
	protected Value mulInt(Int val){
		return new Int(val.getValue() + getValue());
	}

}
