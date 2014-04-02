package ast.value;

public abstract class Value {
	
	public abstract Object getValue();
	public abstract boolean isDefined();
	
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value Eq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value neqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value eqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	
	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value gtInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value ltInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value geqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value leqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	protected Value eqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value neqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
}
