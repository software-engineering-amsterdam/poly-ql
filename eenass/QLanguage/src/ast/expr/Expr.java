package ast.expr;

import typecheck.SymbolTable;
import ast.ASTNode;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public abstract class Expr extends ASTNode{
	public abstract <T> T accept(ExprVisitor<T> visitor);
	public abstract Type typeof(SymbolTable symboles);
}
