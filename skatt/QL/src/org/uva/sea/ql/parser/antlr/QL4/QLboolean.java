package org.uva.sea.ql.parser.antlr.QL4;

/**
 * QLboolean object for QL4 grammar. Is an instance of Value and acts as
 * a type of value in the QL4 package.
 * @author Sammie Katt
 *
 */
public class QLboolean extends Value {
	/**
	 * The value of the object QLboolean
	 */
	boolean value;
	
	/**
	 * Constructor for when initiated with a string. The 
	 * input will be translated to a boolean: true or 1 means true, 
	 * while the rest mean false
	 * @param value
	 */
	QLboolean(String value) {
		
		this.value = value.equalsIgnoreCase("true") 
				|| value.equalsIgnoreCase("1");
	}
	
	/**
	 * Constructor for QLboolean when initiated with a boolean
	 * This.value is set to the input param value
	 * @param value the value that our object will have
	 */
	QLboolean(Boolean value) {
		this.value = value;
	}
	
	/**
	 * returns the value as a boolean
	 * @return value
	 */
	public Boolean asBoolean() {
		return value;
	}
	
	/**
	 * Implements the asValue() function. Returns its value
	 * @return the value of QLboolean
	 */
	public Boolean asValue() {
		return this.value;
	}
	
	/**
	 * return either true of false, depending on value
	 * @return value as string
	 */
	public String toString() {
		return (value) ? "true" : "false";
	}
}
