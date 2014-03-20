package problems;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class CompatibleError extends Error{
	
	public CompatibleError(Expression left, Expression right, TypeEnvironment environment){
		super(left.toString() + " of type " + left.typeOf(environment) + " cannot be compared with " + right.toString() + " of type " + right.typeOf(environment));
	}

}
