package expr;

import typeChecker.ASTVisitor;
import typeChecker.IdentifiersTypeMatcher;
import types.Type;


public class Ident extends Expression {
	protected String identifier;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}

	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return typeMatcher.getIdentType(this);
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
	public String toString() {
		return this.identifier;
	}

	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this))
			return true;
		return false;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return this.identifier.hashCode();
	}
}
