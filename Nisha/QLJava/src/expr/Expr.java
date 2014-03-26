package expr;

import java.util.Map;

import ast.ASTNode;
import ast.type.Type;

public abstract class Expr implements ASTNode{

	public abstract Type typeof(Map<Ident,Type> symboles);
	
	

}
