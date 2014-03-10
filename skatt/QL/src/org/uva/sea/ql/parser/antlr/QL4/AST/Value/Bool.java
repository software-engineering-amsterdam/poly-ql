package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

/**
 * Representation of a boolean in the QL4 AST
 * @author Sammie Katt
 *
 */
public class Bool extends Value {

	private final boolean value;
	
	/**
	 * Constructor instantiates object and sets its value
	 * Converts string input to boolean
	 * Ignores cases (so tRue is considered true)
	 */
	public Bool(String stringValue) {
		this.value = (stringValue.equalsIgnoreCase("true")) ? true : false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bool other = (Bool) obj;
		if (value != other.value)
			return false;
		return true;
	}

	public String toString() {
		return String.valueOf(value);
	}
}
