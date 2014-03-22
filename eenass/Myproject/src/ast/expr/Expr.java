package ast.expr;

import typecheck.SymbolTable;
import ast.ASTNode;
import ast.types.Type;

public abstract class Expr implements ASTNode{
	public abstract Type typeof(SymbolTable symboles);
}
