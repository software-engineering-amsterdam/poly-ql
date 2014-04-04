package ql.ast.node;

import java.util.Map;

import ql.ast.interpreter.LiteralWithoutValue;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Ident extends Expression {
	private String identifier;

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
		return identifier.equals(ident.identifier);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return identifier;
	}

	@Override
	public boolean contains(Ident i) {
		if(i.equals(this))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return identifier.hashCode();
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		Expression e = identifiers.get(this);
		if(e == null)
			return new LiteralWithoutValue();
		return e.eval(identifiers);
	}

	public String getValue() {
		return identifier;
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return typeMatcher.getIdentType(this).isBool();
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}
}
