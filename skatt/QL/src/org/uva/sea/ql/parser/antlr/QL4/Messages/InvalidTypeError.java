package org.uva.sea.ql.parser.antlr.QL4.Messages;

import java.util.HashMap;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Represents the error of an invalid type in an expression
 * @author Sammie Katt
 *
 */
public class InvalidTypeError extends QLErrorMsg {

	private final Expression expr;
	private final Type type;

	public InvalidTypeError(Expression expr, Type type) {
		this.type = type;
		this.expr = expr;
	}
	
	@Override
	public String toString() {
		return "Expression " + expr + " does not contain expected type " + type + ", but type " + expr.getType(new HashMap<Identifier, Question>());
	}
}
