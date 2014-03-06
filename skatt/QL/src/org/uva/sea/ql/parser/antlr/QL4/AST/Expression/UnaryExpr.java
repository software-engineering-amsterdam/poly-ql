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
}
