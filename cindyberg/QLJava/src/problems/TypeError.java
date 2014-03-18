package problems;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.type.Type;

public class TypeError extends Error{

	public TypeError(Expression expression, Type type) {
		super(expression.toString() +" is not of type " + type.toString());
	}


}
