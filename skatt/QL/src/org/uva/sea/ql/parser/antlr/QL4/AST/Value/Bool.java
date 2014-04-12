package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Representation of a boolean in the QL4 AST
 * @author Sammie Katt
 *
 */
public class Bool extends Value {

	private final boolean value;
	
	/**
	 * Constructors, setting value
	 */
	public Bool(String stringValue) {
		this.value = (stringValue.equalsIgnoreCase("true")) ? true : false;
	}
	
	public Bool(boolean bool) {
		this.value = bool;
	}

	/**
	 * returns negation of this object
	 */
	@Override
	public Value negate() {
		Boolean returnValue = !value;
		return new Bool(returnValue.toString());
	}
	
	/**
	 * double dispatch
	 */
	@Override
	public Value or(Value val) {
		return val.orBool(this);
	}
	
	@Override
	public Value and(Value val) {
		return val.andBool(this);
	}
	
	/**
	 * return bool and/or this
	 */
	@Override
	public Value orBool(Bool bool) {
		Bool returnBool;
		
		Bool trueBool = new Bool("true");
		if (trueBool.equals(bool) || this.equals(trueBool)) {
			returnBool = new Bool("true");
		} else {
			returnBool = new Bool("false");
		}
		
		return returnBool;
	}
	
	@Override
	public Value andBool(Bool bool) {
		Bool returnBool;
		
		Bool trueBool = new Bool("true");
		if (trueBool.equals(bool) && this.equals(trueBool)) {
			returnBool = new Bool("true");
		} else {
			returnBool = new Bool("false");
		}
		
		return returnBool;
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new BoolType();
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

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
