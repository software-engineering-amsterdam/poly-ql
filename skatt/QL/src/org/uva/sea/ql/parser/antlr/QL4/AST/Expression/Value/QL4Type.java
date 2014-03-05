package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Value;

/**
 * Represents a label in QL AST
 * @author Sammie Katt
 *
 */
public class QL4Type extends QL4Value {
	String value;
	
	public QL4Type(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
