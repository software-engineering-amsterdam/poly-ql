package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the Less or equal to expression in QL4 AST
 * @author Sammie
 *
 */
public class QL4LeqExpr extends QL4BinairExpr {

	public QL4LeqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "LessOrEq(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
