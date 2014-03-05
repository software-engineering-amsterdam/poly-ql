package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the not equal exression in QL4 AST
 * @author Sammie Katt
 *
 */
public class NeqExpr extends BinaryExpr {

	public NeqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "NotEqual(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
