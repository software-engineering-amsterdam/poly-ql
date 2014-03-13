package problems;

import org.uva.sea.ql.ast.Expression;

public class CompatibleError extends Error{
	
	public CompatibleError(Expression left, Expression right){
	super(left.toString() + " cannot be compared with " + right.toString());
	}

}
