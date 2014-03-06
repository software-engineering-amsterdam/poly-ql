package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents a min expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class MinExpr extends BinaryExpr {

	public MinExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Min(" + super.toString() + ")";
	}
}
