package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Value;

/**
 * Class for AST representation of identifiers in QL
 * @author Sammie Katt
 *
 */
public class QL4Identifier extends QL4Value {
	/**
	 * The actual value of the identifier
	 */
	String value;
	
	/**
	 * Constructor, setting value of the identifier class
	 * @param value
	 */
	public QL4Identifier(String value) {
		this.value = value;
	}
	
	/**
	 * Regular to string, returns the value
	 */
	public String toString() {
		return value;
	}
}
