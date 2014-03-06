package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Represents QL AST label node
 * @author Sammie Katt
 *
 */
public class Label extends Value {
	private final String value;
	
	public Label(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
