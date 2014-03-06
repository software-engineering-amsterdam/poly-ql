package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents the Less or equal to expression in QL4 AST
 * @author Sammie
 *
 */
public class LeqExpr extends BinaryExpr {

	public LeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Leq(" + super.toString() + ")";
	}
}
