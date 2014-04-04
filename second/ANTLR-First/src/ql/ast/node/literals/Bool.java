package ql.ast.node.literals;

import java.util.Map;

import ql.ast.node.Ident;
import ql.ast.node.types.BoolType;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Bool extends Literal {
	private boolean value;

	public Bool(boolean value) {
		this.value=value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bool))
			return false;
		Bool expr=(Bool) obj;
		return expr.value == value;
	}

	@Override
	public boolean hasValue() {
		return true;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Boolean getValueIfBoolean() { 
		return new Boolean(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new BoolType();
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
	public Literal eq(boolean value) {
		return new Bool(this.value == value);
	}

	@Override
	public Literal neq(Literal operand) {
		return operand.neq(value);
	}

	@Override
	public Literal neq(boolean value) {
		return new Bool(this.value != value);
	}

	@Override
	public Literal not() {
		return new Bool(!value);
	}

	@Override
	public Literal and(Literal operand) {
		return operand.and(value);
	}

	@Override
	public Literal and(boolean value) {
		return new Bool(value && this.value);
	}

	@Override
	public Literal or(Literal operand) {
		return operand.or(value);
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
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		return true;	
	}
}
