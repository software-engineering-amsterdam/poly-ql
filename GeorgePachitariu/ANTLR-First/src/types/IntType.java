package types;

import visitor.ASTVisitor;


public class IntType implements Type {

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "int";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return false;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return true;
	}

	@Override
	public boolean isCompatibleWithMoney() {
		return false;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithInt();
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isArithmetic() {
		return true;
	}

	@Override
	public boolean isRelational() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IntType))
			return false;
		return true;
	}
}
