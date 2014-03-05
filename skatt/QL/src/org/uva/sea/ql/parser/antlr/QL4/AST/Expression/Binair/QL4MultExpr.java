package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a multiplication expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4MultExpr extends QL4BinairExpr {

	public QL4MultExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Mult( " + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
