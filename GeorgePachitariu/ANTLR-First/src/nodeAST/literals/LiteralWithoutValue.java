package nodeAST.literals;

import java.util.Map;

import nodeAST.Expression;
import nodeAST.Ident;


import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;

public class LiteralWithoutValue extends Literal {

	@Override
	public void accept(ASTVisitor visitor) { }

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return null;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LiteralWithoutValue;
	}

	@Override
	public boolean containsTreeNode(Expression e) {
		return false;
	}

	@Override
	public boolean isLiteralWithoutValue() {
		return true;
	}

	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
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
}
