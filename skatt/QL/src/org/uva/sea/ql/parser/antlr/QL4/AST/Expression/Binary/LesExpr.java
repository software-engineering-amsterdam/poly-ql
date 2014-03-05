package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the less than expression in QL4 AST
 * @author Sammie
 *
 */
public class LesExpr extends BinaryExpr {

	public LesExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "LessThan(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
