package org.uva.sea.ql.parser.antlr.QL4.Types;


/**
 * Represents the mathematical or numeric type in QL DSL
 * @author Sammie Katt
 *
 */
public class NumberType extends Type {

	@Override
	public int hashCode() {
		return 101;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() == obj.getClass())
			return true;
		else 
			return false;
		
	}
}
