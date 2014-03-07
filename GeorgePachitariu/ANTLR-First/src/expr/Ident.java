package expr;

import typeChecker.ASTVisitor;
import types.Type;


public class Ident extends Expression {
	private String identifier;
	private Type type;

	public Ident(String identifier) {
		super();
		this.identifier=identifier;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return this.type;
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
	public boolean areOperandsTypeValid() {
		return true;
	}

	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this))
			return true;
		return false;
	}
}
