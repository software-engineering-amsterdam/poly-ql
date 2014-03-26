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
}
