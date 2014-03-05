package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the not equal exression in QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4NeqExpr extends QL4BinairExpr {

	public QL4NeqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "NotEqual(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
