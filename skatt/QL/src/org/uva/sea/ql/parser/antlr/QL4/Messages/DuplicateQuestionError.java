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
		DuplicateQuestionError other = (DuplicateQuestionError) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
