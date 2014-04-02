package ast.value;

public class Str extends Value{

	private final String value;
	
	public Str(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean isDefined() {
		return true;
	}

}
