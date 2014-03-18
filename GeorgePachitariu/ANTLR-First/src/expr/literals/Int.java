package expr.literals;

import java.util.Map;

import expr.Expression;
import expr.Ident;
import types.IntType;
import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;


public class Int extends Literal {
	protected int value;

	public Int(int value) {
		super();
		this.value=value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Int))
			return false;
		Int expr=(Int) obj;
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
		return new IntType();
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
	public Literal add(Literal lit) {
		return lit.add(this.value);
	}
	
	@Override
	public Literal add(int value) {
		return new Int(this.value+value);
	}
	
	@Override
	public Literal div(Literal operand) {
		return operand.div(this.value);
	}

	@Override
	public Literal div(int value) {
		return new Int(value/this.value);
	}

	@Override
	public Literal mul(Literal operand) {
		return operand.mul(this.value);
	}

	@Override
	public Literal mul(int value) {
		return new Int(value*this.value);
	}

	@Override
	public Literal sub(Literal operand) {
		return operand.sub(this.value);
	}

	@Override
	public Literal sub(int value) {
		return new Int(value-this.value);
	}

	@Override
	public Literal eq(Literal operand) {
		return operand.eq(this.value);
	}

	@Override
	public Literal eq(int value) {
		return new Bool(this.value==value);
	}

	@Override
	public Literal geq(Literal operand) {
		return operand.geq(this.value);
	}

	@Override
	public Literal geq(int value) {
		return new Bool(value>=this.value);
	}

	@Override
	public Literal gt(Literal operand) {
		return operand.gt(this.value);
	}

	@Override
	public Literal gt(int value) {
		return new Bool(value>this.value);
	}

	@Override
	public Literal leq(Literal operand) {
		return operand.leq(this.value);
	}

	@Override
	public Literal leq(int value) {
		return new Bool(value<=this.value);
	}

	@Override
	public Literal lt(Literal operand) {
		return operand.lt(this.value);
	}

	@Override
	public Literal lt(int value) {
		return new Bool(value<this.value);
	}

	@Override
	public Literal neq(Literal operand) {
		return operand.neq(this.value);
	}

	@Override
	public Literal neq(int value) {
		return new Bool(this.value!=value);
	}

	@Override
	public Literal neg() {
		return new Int(-this.value);
	}

	@Override
	public Literal pos() {
		return new Int(this.value);
	}
}
