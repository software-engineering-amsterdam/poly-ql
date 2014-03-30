package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;



/**
 * Abstract class for all unary expressions (braces and ! operator). 
 * Contains a single expression and a constructor.
 * 
 * @author Sammie Katt
 *
 */
public abstract class UnaryExpr extends Expression {

	final private Expression expr;
	
	public UnaryExpr(Expression expr) {
		this.expr = expr;
	}
	
	public String toString() {
		return expr.toString();
	}

	public Expression getExpr() {
		return expr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
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
		UnaryExpr other = (UnaryExpr) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		return true;
	}
	
	
}
