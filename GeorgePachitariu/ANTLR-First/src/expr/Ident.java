package expr;

import typeChecker.ASTVisitor;


public class Ident extends Expression {
	private String identifier;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident))
			return false;
		Ident ident=(Ident) obj;
		return this.identifier.equals(ident.identifier);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean isBoolean() {
		return false;
	}
	
	public String toString() {
		return this.identifier;
	}
}
