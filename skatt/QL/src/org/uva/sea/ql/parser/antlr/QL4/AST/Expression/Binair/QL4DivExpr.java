package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a division expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4DivExpr extends QL4BinairExpr {

	public QL4DivExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "Div( " + lhs.toString() + ", " + rhs.toString();
	}
}
