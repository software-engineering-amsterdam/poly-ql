package ql.ast.node.literals;

import java.util.Map;

import ql.ast.node.Ident;
import ql.ast.node.types.StringType;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Str extends Literal {
	private String value;

	public Str(String value) {
		this.value=value;
	}

	@Override
	public boolean hasValue() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Str))
			return false;
		Str expr=(Str) obj;
		return expr.value.equals(value);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new StringType();
	}

	@Override
	public boolean contains(Ident i) {
		if(i.equals(this))
			return true;
		return false;
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return this;
	}

	@Override
	public Literal eq(Literal operand) {
		return operand.eq(value);
	}

	@Override
	public Literal eq(String value) {
		return new Bool(this.value.equals(value));
	}

	@Override
	public Literal neq(Literal operand) {
		return operand.neq(value);
	}

	@Override
	public Literal neq(String value) {
		return new Bool(! this.value.equals(value));
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return false;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}
}
