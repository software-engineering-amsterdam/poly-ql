package ast.evaluate;

public abstract class Value {

	//conditional
	
	public Value and(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value andBool(Bool obj) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value orBool(Bool obj) {
		throw new UnsupportedOperationException();
	}
	
	//arithmatic
	
	public Value add(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value sub(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value div(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	public Value mul(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	//relational
	
	public Value eq(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value eqBool(Bool obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value neqBool(Bool obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value gtInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value ltInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	public Value leq(Value obj) {
		throw new UnsupportedOperationException();
	}
	
	protected Value leqInt(Int obj) {
		throw new UnsupportedOperationException();
	}
	
	//unary
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	
}
