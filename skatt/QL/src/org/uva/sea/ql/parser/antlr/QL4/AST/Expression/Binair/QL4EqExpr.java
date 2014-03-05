package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents Equality expression in QL4 AST
 * @author Sammie
 *
 */
public class QL4EqExpr extends QL4BinairExpr {

	public QL4EqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "Equals(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
