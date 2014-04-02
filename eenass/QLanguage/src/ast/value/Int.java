package ast.value;

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
		return val.subInt(this);
	}
	
	@Override
	protected Value subInt(Int val){
		return new Int(val.getValue() - getValue());
	}
	
	@Override
	public Value div(Value val){
		return val.divInt(this);
	}
	
	@Override
	protected Value divInt(Int val){
		return new Int(val.getValue() / getValue());
	}
	
	@Override
	public Value mul(Value val){
		return val.mulInt(this);
	}
	
	@Override
	protected Value mulInt(Int val){
		return new Int(val.getValue() * getValue());
	}
	
	@Override
	public Value gt(Value val){
		return val.gtInt(this);
	}
	
	@Override
	protected Value gtInt(Int val){
		return new Bool(val.getValue() > getValue());
	}
	
	@Override
	public Value lt(Value val){
		return val.ltInt(this);
	}
	
	@Override
	protected Value ltInt(Int val){
		return new Bool(val.getValue() < getValue());
	}
	
	@Override
	public Value geq(Value val){
		return val.geqInt(this);
	}
	
	@Override
	protected Value geqInt(Int val){
		return new Bool(val.getValue() >= getValue());
	}
	
	@Override
	public Value leq(Value val){
		return val.leqInt(this);
	}
	
	@Override
	protected Value leqInt(Int val){
		return new Bool(val.getValue() <= getValue());
	}
	
	@Override
	public Value pos(){
		return new Int(+ getValue());
	}
	
	@Override
	public Value neg(){
		return new Int(- getValue());
	}
	
	@Override
	public Value eq(Value val){
		return val.eqInt(this);
	}
	
	@Override
	protected Value eqInt(Int val){
		return new Bool(val.getValue() == getValue());
	}
	
	@Override
	public Value neq(Value val){
		return val.neqInt(this);
	}
	
	@Override
	protected Value neqInt(Int val){
		return new Bool(val.getValue() != getValue());
	}

	@Override
	public boolean isDefined() {
		return true;
	}

}
