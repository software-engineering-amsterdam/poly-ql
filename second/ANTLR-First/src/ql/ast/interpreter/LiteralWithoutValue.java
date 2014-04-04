package ql.ast.interpreter;

import java.util.Map;

import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;




public class LiteralWithoutValue extends Literal {

	@Override
	public void accept(ASTVisitor visitor) { }

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LiteralWithoutValue;
	}

	@Override
	public boolean contains(Ident i) {
		return false;
	}

	@Override
	public boolean hasValue() {
		return false;
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return this;
	}

	public Literal add(Literal literal) {
		return this;
	}

	public Literal div(Literal operand) {
		return this;
	}

	public Literal mul(Literal operand) {
		return this;
	}

	public Literal sub(Literal operand) {
		return this;
	}

	public Literal eq(Literal operand) {
		return this;
	}

	public Literal geq(Literal operand) {
		return this;
	}

	public Literal gt(Literal operand) {
		return this;
	}

	public Literal leq(Literal operand) {
		return this;
	}

	public Literal lt(Literal operand) {
		return this;
	}

	public Literal neq(Literal operand) {
		return this;
	}

	public Literal neg() {
		return this;
	}

	public Literal not() {
		return this;
	}

	public Literal pos() {
		return this;
	}

	public Literal and(Literal operand) {
		return this;
	}

	public Literal or(Literal operand) {
		return this;
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		assert false;
		return false;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		assert false;
		return false;
	}
}
