package org.uva.sea.ql.parser.antlr.QL4.Messages;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;

/**
 * Represents the error when a cyclic dependency is present.
 * @author Sammie Katt
 */
public class CyclicDependencyError extends QLErrorMsg {

	private final Identifier id1, id2;
	
	public CyclicDependencyError(Identifier id1, Identifier id2) {
		this.id1 = id1;
		this.id2 = id2;
	}
	
	@Override
	public String toString() {
		return "Question " + id1 + " and " + id2 + " are cyclic dependent on eachother";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
		result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
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
		CyclicDependencyError other = (CyclicDependencyError) obj;
		if (id1 == null) {
			if (other.id1 != null)
				return false;
		} else if (!id1.equals(other.id1) && !id1.equals(other.id2))
			return false;
		if (id2 == null) {
			if (other.id2 != null)
				return false;
		} else if (!id2.equals(other.id2) && !id2.equals(other.id1))
			return false;
		return true;
	}
	
	
}
