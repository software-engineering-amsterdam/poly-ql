package expr;

import java.util.Map;

import expr.literals.Literal;
import types.Type;
import visitor.IdentifiersTypeMatcher;

public abstract class Expression implements ASTNode{

	public abstract Type getType(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean containsTreeNode(Expression e);
	
	public abstract Literal compute(Map <Ident, Expression> identifiers);
}
