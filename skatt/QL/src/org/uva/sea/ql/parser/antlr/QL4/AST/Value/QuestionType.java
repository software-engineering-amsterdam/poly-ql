package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents a label in QL AST
 * @author Sammie Katt
 *
 */
public class QuestionType extends Value {
	private final String value;
	
	public QuestionType(String value) {
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
		QuestionType other = (QuestionType) obj;
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