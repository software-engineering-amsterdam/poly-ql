package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Represents INTEGER in QL AST. 
 * @author Sammie
 *
 */
public class Number extends Value {

	private final String value;
	
	public Number(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}

}
