package expr;

import java.util.Map;

import ast.ASTNode;
import ast.Visitor;
import ast.type.Type;

public abstract class Expr implements ASTNode{

	public abstract <T> T accept(Visitor<T> visitor);
	public abstract Type typeof(Map<Ident,Type> symboles);
	
	

}
