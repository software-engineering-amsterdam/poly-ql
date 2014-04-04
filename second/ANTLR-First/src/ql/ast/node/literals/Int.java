package ql.ast.node.literals;

import java.util.Map;

import ql.ast.node.Ident;
import ql.ast.node.types.IntType;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Int extends Literal {
	private int value;

	public Int(int value) {
		this.value=value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Int))
			return false;
		Int expr=(Int) obj;
		return expr.value == value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public boolean hasValue() {
		return true;
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new IntType();
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
	public Literal add(Literal lit) {
		return lit.add(value);
	}

	@Override
	public Literal add(int value) {
		return new Int(this.value+value);
	}

	@Override
	public Literal div(Literal operand) {
		return operand.div(value);
	}

	@Override
	public Literal div(int value) {
		return new Int(value/this.value);
	}

	@Override
	public Literal mul(Literal operand) {
		return operand.mul(value);
	}

	@Override
	public Literal mul(int value) {
		return new Int(value*this.value);
	}

	@Override
	public Literal sub(Literal operand) {
		return operand.sub(value);
	}

	@Override
	public Literal sub(int value) {
		return new Int(value-this.value);
	}

	@Override
	public Literal eq(Literal operand) {
		return operand.eq(value);
	}

	@Override
	public Literal eq(int value) {
		return new Bool(this.value==value);
	}

	@Override
	public Literal geq(Literal operand) {
		return operand.geq(value);
	}

	@Override
	public Literal geq(int value) {
		return new Bool(value>=this.value);
	}

	@Override
	public Literal gt(Literal operand) {
		return operand.gt(value);
	}

	@Override
	public Literal gt(int value) {
		return new Bool(value>this.value);
	}

	@Override
	public Literal leq(Literal operand) {
		return operand.leq(value);
	}

	@Override
	public Literal leq(int value) {
		return new Bool(value<=this.value);
	}

	@Override
	public Literal lt(Literal operand) {
		return operand.lt(value);
	}

	@Override
	public Literal lt(int value) {
		return new Bool(value<this.value);
	}

	@Override
	public Literal neq(Literal operand) {
		return operand.neq(value);
	}

	@Override
	public Literal neq(int value) {
		return new Bool(this.value!=value);
	}

	@Override
	public Literal neg() {
		return new Int(-value);
	}

	@Override
	public Literal pos() {
		return new Int(value);
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
