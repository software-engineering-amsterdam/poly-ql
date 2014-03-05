package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents a multiplication expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class MultExpr extends BinaryExpr {

	public MultExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Mult( " + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
