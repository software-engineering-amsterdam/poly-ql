package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents INTEGER in QL AST. 
 * @author Sammie Katt
 *
 */
public class Number extends Value {

	private final int value;
	
	public Number(String value) {
		this.value = Integer.valueOf(value);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Number other = (Number) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new NumberType();
	}
	
	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
