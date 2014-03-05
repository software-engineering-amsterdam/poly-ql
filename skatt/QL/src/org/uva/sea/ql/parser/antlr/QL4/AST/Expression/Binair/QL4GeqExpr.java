package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the greater or equal expression in QL4 AST
 * @author Sammie
 *
 */
public class QL4GeqExpr extends QL4BinairExpr {

	public QL4GeqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "GreatOrEq(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
