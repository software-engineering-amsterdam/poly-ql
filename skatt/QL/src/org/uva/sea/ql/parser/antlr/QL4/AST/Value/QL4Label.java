package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Represents QL AST label node
 * @author Sammie Katt
 *
 */
public class QL4Label extends QL4Value {
	String value;
	
	public QL4Label(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
