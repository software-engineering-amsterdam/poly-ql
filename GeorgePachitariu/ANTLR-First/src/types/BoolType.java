package types;

import typeChecker.ASTVisitor;


public class BoolType implements Type {

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return true;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return false;
	}

	@Override
	public boolean isCompatibleWithMoney() {
		return false;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBoolean();
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean isArithmetic() {
		return false;
	}

	@Override
	public boolean isRelational() {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BoolType))
			return false;
		return true;
	}
}
