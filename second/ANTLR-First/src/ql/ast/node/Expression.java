package ql.ast.node;

import java.util.Map;

import ql.ast.node.literals.Literal;
import ql.ast.node.types.Type;
import ql.ast.visitor.IdentifiersTypeMatcher;

public abstract class Expression implements ASTNode{

	public abstract Type getType(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean contains(Ident e);

	public abstract Literal eval(Map<Ident, Literal> identifiers);
	public abstract boolean isBoolean(IdentifiersTypeMatcher typeMatcher);
	public abstract boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher);
}
