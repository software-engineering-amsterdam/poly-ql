package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Class for AST representation of identifiers in QL
 * @author Sammie Katt
 *
 */
public class Identifier extends Value {
	/**
	 * The actual value of the identifier
	 */
	String value;
	
	/**
	 * Constructor, setting value of the identifier class
	 * @param value
	 */
	public Identifier(String value) {
		this.value = value;
	}
	
	/**
	 * Regular to string, returns the value
	 */
	public String toString() {
		return value;
	}
}
