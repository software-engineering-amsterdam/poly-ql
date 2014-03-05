package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents and expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class AndExpr extends BinaryExpr {

	public AndExpr(QL4Tree lhs, QL4Tree rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "And(" + lhs.toString() + ", " + rhs.toString() + ")";
	}

}
