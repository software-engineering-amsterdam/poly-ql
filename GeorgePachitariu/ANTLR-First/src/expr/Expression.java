package expr;

import typeChecker.IdentifiersTypeMatcher;
import types.Type;

public abstract class Expression implements ASTNode{

	public abstract Type getType(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean containsTreeNode(Expression e);
}
