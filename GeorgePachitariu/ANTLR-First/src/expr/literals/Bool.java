package expr.literals;

import expr.Expression;
import typeChecker.ASTVisitor;
import typeChecker.IdentifiersTypeMatcher;
import types.BoolType;
import types.Type;


public class Bool extends Expression {
	protected boolean value;

	public Bool(boolean value) {
		super();
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
		return "boolean";
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
}
