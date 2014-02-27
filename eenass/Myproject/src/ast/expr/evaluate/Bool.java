package ast.expr.evaluate;

public class Bool extends Value{
	
	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

}
