package types;

import visitor.ASTVisitor;


public class MoneyType implements Type {

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "money";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return false;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return false;
	}

	@Override
	public boolean isCompatibleWithMoney() {
		return true;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithMoney();
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
		if (!(obj instanceof MoneyType))
			return false;
		return true;
	}
}