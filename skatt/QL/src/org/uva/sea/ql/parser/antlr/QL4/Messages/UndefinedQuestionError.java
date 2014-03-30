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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UndefinedQuestionError other = (UndefinedQuestionError) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
