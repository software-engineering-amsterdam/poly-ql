package org.uva.sea.ql.parser.antlr.QL4;

public class QLdouble extends Value{


	/**
	 * The value of the object QLintger is an int
	 */
	double value;
	
	/**
	 * Returns whether the input value has the same value as this
	 * @param value is the value to compare with
	 * @return is a boolean, evaluating the equality
	 */
	public Boolean equals(Value value) {
		return Double.compare(this.value, value.asDouble()) == 0;
	}
	
	/**
	 * Constructor for when initiated with a string. The 
	 * input will be translated to an double: 
	 * 
	 * @param value as a string
	 */
	QLdouble(String value) {
		this.value = Double.parseDouble(value);
	}
	
	/**
	 * Constructor for when initiated with a double 
	 * 
	 * @param value 
	 */
	QLdouble(double value) {
		this.value = value;
	}
	
	
	/**
	 * returns the value as a boolean (check if its 1.0)
	 * @return value as boolean
	 */
	public Boolean asBoolean() {
		return value == 1.0;
	}

	/**
	 * returns the value as int
	 * @return value as int
	 */
	public Integer asInteger() {
		return (int) this.value;
	}

	/**
	 * returns the value 
	 * @return value 
	 */
	public Double asDouble() {
		return this.value;
	}
	
	/**
	 * return the value as a string by String.parse
	 * @return value as string
	 */
	public String toString() {
		return String.valueOf(value);
	}

	
}
