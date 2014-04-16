package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * Represents INTEGER in QL AST. 
 * @author Sammie Katt
 *
 */
public class Number extends Value {

	private final int value;
	
	/**
	 * Constructors
	 */
	public Number(String value) {
		this.value = Integer.valueOf(value);
	}

	public Number(int value) {
		this.value = value;
	}
	
	/**
	 * Overridden double dispatch min/plus/div/mult
	 */
	@Override
	public Value plus(Value val) {
		return val.plusNumber(this);
	}
	
	@Override
	public Value min(Value val) {
		return val.minNumber(this);
	}
	
	public Value div(Value val) {
		return val.divNumber(this);
	}
	
	public Value mult(Value val) {
		return val.multNumber(this);
	}

	
	/**
	 * Override this +/-* number
	 */
	@Override
	public Value plusNumber(Number val) {
		return new Number(val.getValue() + this.getValue());
	}
	
	@Override
	public Value minNumber(Number val) {
		return new Number(val.getValue() - this.getValue());
	}
	
	@Override
	public Value multNumber(Number val) {
		return new Number(val.getValue() * this.getValue());
	}
	
	@Override
	public Value divNumber(Number val) {
		// returns decimal after dividing
		return new Decimal((double) val.getValue() / this.getValue());
	}
	
	/**
	 * Override this +/-* decimal
	 */
	@Override
	public Value plusDec(Decimal val) {
		return new Decimal(val.getValue() + this.getValue());
	}
	
	@Override
	public Value minDec(Decimal val) {
		return new Decimal(val.getValue() - this.getValue());
	}
	
	@Override
	public Value multDec(Decimal val) {
		return new Decimal(val.getValue() * this.getValue());
	}
	
	@Override
	public Value divDec(Decimal val) {
		return new Decimal(val.getValue() / this.getValue());
	}
	
	/**
	 * Overridden double dispatch > < => =<
	 */
	@Override
	public Value geq(Value val) {
		return val.geqNumber(this);
	}
	
	@Override
	public Value leq(Value val) {
		return val.leqNumber(this);
	}
	
	public Value les(Value val) {
		return val.lesNumber(this);
	}
	
	public Value gre(Value val) {
		return val.greNumber(this);
	}

	
	/**
	 * Override this > < => =< number
	 */
	@Override
	public Value geqNumber(Number val) {
		return new Bool(val.getValue() >= this.getValue());
	}
	
	@Override
	public Value leqNumber(Number val) {
		return new Bool(val.getValue() <= this.getValue());
	}
	
	@Override
	public Value greNumber(Number val) {
		return new Bool(val.getValue() > this.getValue());
	}
	
	@Override
	public Value lesNumber(Number val) {
		return new Bool(val.getValue() < this.getValue());
	}
	
	/**
	 * Override this > < => =< decimal
	 */
	@Override
	public Value geqDec(Decimal val) {
		return new Bool(val.getValue() >= this.getValue());
	}
	
	@Override
	public Value leqDec(Decimal val) {
		return new Bool(val.getValue() <= this.getValue());
	}
	
	@Override
	public Value greDec(Decimal val) {
		return new Bool(val.getValue() > this.getValue());
	}
	
	@Override
	public Value lesDec(Decimal val) {
		return new Bool(val.getValue() < this.getValue());
	}

	/**
	 * Hash and equals
	 */
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

	/**
	 * Getters
	 */
	public int getValue() {
		return this.value;
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new NumberType();
	}
	
	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	
	
}
