package interpreter;

import java.util.Map;

import expr.ASTNode;
import expr.Expression;
import expr.Ident;
import expr.literals.Literal;

public class ValueComputer  {
	
	public Literal compute(Expression e, ASTNode root) {
		Map<Ident, Expression> identifiers;
		identifiers= new IdentifiersCollecter().collect(root);		
		return e.compute(identifiers);
	}	
}
