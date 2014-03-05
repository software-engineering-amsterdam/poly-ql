package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a plus expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class PlusExpr extends BinaryExpr{

	public PlusExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Plus( " + lhs.toString() + ", " + rhs.toString() + ")";
	}
}
