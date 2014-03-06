package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Represents a label in QL AST
 * @author Sammie Katt
 *
 */
public class QuestionType extends Value {
	private final String value;
	
	public QuestionType(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
