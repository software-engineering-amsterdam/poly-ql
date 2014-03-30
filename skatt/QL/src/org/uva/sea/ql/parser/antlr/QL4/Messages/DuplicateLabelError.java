package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Label;

/**
 * Represents an error of duplicates labels in a questionnaire.
 * 
 * @author Sammie Katt
 *
 */
public class DuplicateLabelError extends QLErrorMsg {

	private final Label label;
	
	public DuplicateLabelError(Label label) {
		this.label = label;
	}
	
	public String toString() {
		return "Label " + label + " is a duplicate";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		DuplicateLabelError other = (DuplicateLabelError) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
}
