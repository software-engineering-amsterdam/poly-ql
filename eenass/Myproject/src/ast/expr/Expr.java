package ast.expr;

import typecheck.Symboles;
import ast.ASTNode;
import ast.expr.types.Type;

public abstract class Expr implements ASTNode{
	public abstract Type typeof(Symboles symboles);
}
