package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

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
	Expression lhs;
	Expression rhs;
	
	public BinaryExpr(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
