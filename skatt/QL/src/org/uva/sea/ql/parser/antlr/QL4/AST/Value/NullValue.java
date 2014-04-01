package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NullType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents null in QL4 syntax
 * @author Sammie Katt
 *
 */
public class NullValue extends Value {

	
	public Type getType() {
		return new NullType();
	}
	
	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Null";
	}
	
	@Override
	public int hashCode() {
		return 37; // random prime
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	

}
