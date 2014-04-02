package ast.value;

public class Undefined extends Value{

	public Undefined() {
	}

	@Override
	public Value add(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value addInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value sub(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value subInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value div(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value divInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value mul(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value mulInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value Eq(Value arg) {
		return new Undefined();
	}

	@Override
	public Value and(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value andBool(Bool arg) {
		return new Undefined();
	}

	@Override
	public Value or(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value orBool(Bool arg) {
		return new Undefined();
	}

	@Override
	public Value neq(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value neqBool(Bool arg) {
		return new Undefined();
	}

	@Override
	public Value eq(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value eqBool(Bool arg) {
		return new Undefined();
	}

	@Override
	public Value not() {
		return new Undefined();
	}

	@Override
	public Value gt(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value gtInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value lt(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value ltInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value geq(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value geqInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value leq(Value arg) {
		return new Undefined();
	}

	@Override
	protected Value leqInt(Int arg) {
		return new Undefined();
	}

	@Override
	public Value pos() {
		return new Undefined();
	}

	@Override
	public Value neg() {
		return new Undefined();
	}

	@Override
	protected Value eqInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Value neqInt(Int arg) {
		return new Undefined();
	}

	@Override
	public String toString() {		
		return "undefined";
	}

	@Override
	public String getValue() {
		return toString();
	}

	@Override
	public boolean isDefined() {
		return false;
	}
	
}
