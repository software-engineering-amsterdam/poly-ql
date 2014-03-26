package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;

/**
 * The error thrown whenever a question is refered
 * to that has not been instantiated yet.
 * @author Sammie Katt
 */
public class UndefinedQuestionError extends QLErrorMsg {

	private Identifier id;
	
	public UndefinedQuestionError(Identifier id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Question " + id + " has not been instantiated yet";
	}
}
