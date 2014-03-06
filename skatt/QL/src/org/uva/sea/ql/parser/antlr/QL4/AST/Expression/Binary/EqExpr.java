package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents Equality expression in QL4 AST
 * @author Sammie
 *
 */
public class EqExpr extends BinaryExpr {

	public EqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Eq(" + super.toString() + ")";
	}
}
