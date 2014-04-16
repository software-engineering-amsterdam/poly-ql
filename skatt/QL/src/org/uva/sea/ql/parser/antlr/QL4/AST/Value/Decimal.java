package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * Represents a decimal in the QL AST
 * @author Sammie Katt
 *
 */
public class Decimal extends Value {
	
	private final double value;
	
	/**
	 * Constructors
	 */
	public Decimal(String value) {
		this.value = Double.valueOf(value);
	}
	
	public Decimal(double value) {
		this.value = value;
	}
	
	/**
	 * Overridden double dispatch min/plus/div/mult
	 */
	@Override
	public Value plus(Value val) {
		return val.plusDec(this);
	}
	
	@Override
	public Value min(Value val) {
		return val.minDec(this);
	}
	
	public Value div(Value val) {
		return val.divDec(this);
	}
	
	public Value mult(Value val) {
		return val.multDec(this);
	}
	
	/**
	 * Override this +/-* number
	 */
	@Override
	public Value plusNumber(Number val) {
		
		return new Decimal(val.getValue() + this.getValue());
	}
	
	@Override
	public Value minNumber(Number val) {
		return new Decimal(val.getValue() - this.getValue());
	}
	
	@Override
	public Value multNumber(Number val) {
		return new Decimal(val.getValue() * this.getValue());
	}
	
	@Override
	public Value divNumber(Number val) {
		return new Decimal(val.getValue() / this.getValue());
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
		return val.geqDec(this);
	}
	
	@Override
	public Value leq(Value val) {
		return val.leqDec(this);
	}
	
	public Value les(Value val) {
		return val.lesDec(this);
	}
	
	public Value gre(Value val) {
		return val.greDec(this);
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
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Decimal other = (Decimal) obj;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
	}

	/**
	 * Getters
	 */
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new NumberType();
	}
	
	public double getValue() {
		return this.value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
