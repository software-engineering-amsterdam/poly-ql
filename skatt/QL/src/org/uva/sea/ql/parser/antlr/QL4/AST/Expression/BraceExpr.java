package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;

/**
 * Represents a braced expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class BraceExpr extends Expression {
	QLTree bracedExpr;
	
	public BraceExpr(QLTree expr) {
		this.bracedExpr = expr;
	}
	
	public String toString() {
		return '(' + bracedExpr.toString() + ')';
	}
}
