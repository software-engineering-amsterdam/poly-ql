package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a min expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class MinExpr extends BinaryExpr {

	public MinExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Min( " + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
