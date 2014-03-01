package expr;

import types.Type;

public abstract class Expression implements Expr{
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	public abstract Type getType();
	public abstract boolean areOperandsTypeValid();
	public abstract boolean containsTreeNode(Expression e);
}
