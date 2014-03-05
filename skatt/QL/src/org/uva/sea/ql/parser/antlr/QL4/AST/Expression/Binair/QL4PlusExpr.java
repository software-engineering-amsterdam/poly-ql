package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a plus expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4PlusExpr extends QL4BinairExpr{

	public QL4PlusExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Plus( " + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
