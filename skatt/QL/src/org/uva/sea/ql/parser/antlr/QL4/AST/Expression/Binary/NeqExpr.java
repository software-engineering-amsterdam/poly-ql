package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents the not equal exression in QL4 AST
 * @author Sammie Katt
 *
 */
public class NeqExpr extends BinaryExpr {

	public NeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Neq(" + super.toString() + ")";
	}
}
