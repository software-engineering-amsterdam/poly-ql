package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Class for AST representation of identifiers in QL
 * @author Sammie Katt
 *
 */
public class Identifier extends Value {
	/**
	 * The actual value of the identifier
	 */
	private final String value;
	
	/**
	 * Constructor, setting value of the identifier class
	 * @param value
	 */
	public Identifier(String value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Identifier other = (Identifier) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return value;
	}

}
