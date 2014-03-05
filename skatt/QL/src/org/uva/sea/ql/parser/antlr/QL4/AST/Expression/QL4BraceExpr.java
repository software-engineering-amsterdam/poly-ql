package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;

/**
 * Represents a braced expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class QL4BraceExpr extends QL4Expression {
	QL4Tree bracedExpr;
	
	public QL4BraceExpr(QL4Tree expr) {
		this.bracedExpr = expr;
	}
	
	public String toString() {
		return '(' + bracedExpr.toString() + ')';
	}
}
