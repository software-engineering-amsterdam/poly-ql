package ast.expr.evaluate;

public abstract class Value {
	
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

		
	

}
