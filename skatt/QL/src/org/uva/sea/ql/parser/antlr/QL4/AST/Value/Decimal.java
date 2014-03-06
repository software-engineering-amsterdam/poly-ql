package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Represents a decimal in the QL AST
 * @author Sammie Katt
 *
 */
public class Decimal extends Value {
	
	private final String value;
	
	public Decimal(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}

}
