package org.uva.sea.ql.parser.antlr.QL4.Types;

/**
 * Represents the logical type (boolean) in QL DSL
 * @author Sammie Katt 
 *
 */
public class BoolType extends Type {

	@Override
	public int hashCode() {
		return 103;
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
