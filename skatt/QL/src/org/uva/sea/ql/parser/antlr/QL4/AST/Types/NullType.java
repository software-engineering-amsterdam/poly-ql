package org.uva.sea.ql.parser.antlr.QL4.AST.Types;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

public class NullType extends Type {

	@Override
	public int hashCode() {
		return 113;
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

	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "NullType";
	}

}
