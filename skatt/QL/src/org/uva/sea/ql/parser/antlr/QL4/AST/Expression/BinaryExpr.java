package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;



/**
 * Abstract class for all binair expressions. Contains a lhs and rhs
 * of the expression and a constructor for setting them.
 * @author Sammie Katt
 *
 */
public abstract class BinaryExpr extends Expression {
	/**
	 * The left hand and right hand side of the binair expression
	 */
	private final Expression lhs;
	private final Expression rhs;
	
	public BinaryExpr(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return lhs.toString() + ", " + rhs.toString();
	}
	
	public Expression getLHS() {
		return lhs;
	}
	
	public Expression getRHS() {
		return rhs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
		result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
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
		BinaryExpr other = (BinaryExpr) obj;
		if (lhs == null) {
			if (other.lhs != null)
				return false;
		} else if (!lhs.equals(other.lhs))
			return false;
		if (rhs == null) {
			if (other.rhs != null)
				return false;
		} else if (!rhs.equals(other.rhs))
			return false;
		return true;
	}
	
	
}
