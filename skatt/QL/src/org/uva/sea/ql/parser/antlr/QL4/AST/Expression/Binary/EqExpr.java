package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents Equality expression in QL4 AST
 * @author Sammie
 *
 */
public class EqExpr extends BinaryExpr {

	public EqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "Equals(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
