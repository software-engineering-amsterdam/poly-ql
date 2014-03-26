package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;

/**
 * Represents the error when a duplicate question id is used.
 * @author Sammie Katt
 */
public class DuplicateQuestionError extends QLErrorMsg {

	private final Identifier id;
	
	public DuplicateQuestionError(Identifier id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Question " + id + " has been declared before";
	}
}
