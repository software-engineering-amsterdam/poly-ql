package problems;

import org.uva.sea.ql.ast.Expression;

public class NotDeclaredError extends Error {

	public NotDeclaredError(Expression condition){
		super(condition.toString() + " is not declared ");
	}
}
