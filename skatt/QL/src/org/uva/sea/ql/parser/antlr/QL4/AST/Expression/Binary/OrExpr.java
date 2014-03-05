package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents or expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class OrExpr extends BinaryExpr {

	public OrExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "Or(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
