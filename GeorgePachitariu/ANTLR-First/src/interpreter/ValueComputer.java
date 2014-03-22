package interpreter;

import java.util.Map;

import nodeAST.ASTNode;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.literals.Literal;



public class ValueComputer  {

	public Literal compute(Expression e, ASTNode root) {
		Map<Ident, Expression> identifiers;
		identifiers= new IdentifiersCollecter().collect(root);		
		return e.compute(identifiers);
	}	
}
