package expr;

public class Ident extends Expr {
	private String identifier;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}
}
