package ast.expr;

import typecheck.SymboleTable;
import ast.ASTNode;
import ast.expr.types.Type;

public abstract class Expr implements ASTNode{
	public abstract Type typeof(SymboleTable symboles);
}
