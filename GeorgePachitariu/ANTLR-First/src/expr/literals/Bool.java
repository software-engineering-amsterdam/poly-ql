package expr.literals;

import java.util.Map;

import expr.Expression;
import expr.Ident;
import types.BoolType;
import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


public class Bool extends Literal {
	protected boolean value;

	public Bool(boolean value) {
		this.value=value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bool))
			return false;
		Bool expr=(Bool) obj;
		return expr.value == this.value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new BoolType();
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}

	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this))
			return true;
		return false;
	}
	
	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
		return this;
	}

	@Override
	public Literal eq(Literal operand) {
		return operand.eq(this.value);
	}

	@Override
	public Literal eq(boolean value) {
		return new Bool(this.value == value);
	}

	@Override
	public Literal neq(Literal operand) {
		return operand.neq(this.value);
	}

	@Override
	public Literal neq(boolean value) {
		return new Bool(this.value != value);
	}

	@Override
	public Literal not() {
		return new Bool(!this.value);
	}

	@Override
	public Literal and(Literal operand) {
		return operand.and(this.value);
	}

	@Override
	public Literal and(boolean value) {
		return new Bool(value && this.value);
	}

	@Override
	public Literal or(Literal operand) {
		return operand.or(this.value);
	}

	@Override
	public Literal or(boolean value) {
		return new Bool(value || this.value);
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean getValue() {
		return this.value;
	}
}
