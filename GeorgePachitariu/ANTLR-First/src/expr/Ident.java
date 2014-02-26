package expr;

public class Ident extends Expression {
	private String identifier;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}
}
