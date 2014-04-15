package ast.evaluate;


public class Int extends Value{

	private final Integer value;
	
	public Int(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public Value add(Value obj) {
		return obj.addInt(this);
	}

	@Override
	public Value addInt(Int obj) {
		return new Int(obj.getValue() + getValue());
	}

	@Override
	public Value sub(Value obj) {
		return obj.subInt(this);
	}

	@Override
	protected Value subInt(Int obj) {
		return new Int(obj.getValue() - getValue());
	}

	@Override
	public Value mul(Value obj) {
		return obj.mulInt(this);
	}

	@Override
	protected Value mulInt(Int obj) {
		return new Int(obj.getValue() * getValue());
	}

	@Override
	public Value div(Value obj) {
		return obj.divInt(this);
	}

	@Override
	protected Value divInt(Int obj) {
		return new Int(obj.getValue() / getValue());
	}

	@Override
	public Value neg() {
		return new Int(-getValue());
	}

	@Override
	public Value pos() {
		return new Int(+getValue());
	}

	// comparisons

	@Override
	public Value gt(Value obj) {
		return obj.gtInt(this);
	}

	@Override
	protected Value gtInt(Int obj) {
		return new Bool(obj.getValue() > getValue());
	}

	@Override
	public Value geq(Value obj) {
		return obj.geqInt(this);
	}

	@Override
	protected Value geqInt(Int obj) {
		return new Bool(obj.getValue() >= getValue());
	}

	@Override
	public Value lt(Value obj) {
		return obj.ltInt(this);
	}

	@Override
	protected Value ltInt(Int obj) {
		return new Bool(obj.getValue() < getValue());
	}

	@Override
	public Value leq(Value obj) {
		return obj.leqInt(this);
	}

	@Override
	protected Value leqInt(Int obj) {
		return new Bool(obj.getValue() <= getValue());
	}
	


}