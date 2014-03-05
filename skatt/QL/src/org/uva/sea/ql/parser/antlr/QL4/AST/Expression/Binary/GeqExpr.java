package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents the greater or equal expression in QL4 AST
 * @author Sammie
 *
 */
public class GeqExpr extends BinaryExpr {

	public GeqExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}

	public String toString() {
		return "GreatOrEq(" + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
