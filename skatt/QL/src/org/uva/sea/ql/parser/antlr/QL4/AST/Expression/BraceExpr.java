package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import org.uva.sea.ql.parser.antlr.QL4.AST.Tree;

/**
 * Represents a braced expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class BraceExpr extends Expression {
	Tree bracedExpr;
	
	public BraceExpr(Tree expr) {
		this.bracedExpr = expr;
	}
	
	public String toString() {
		return '(' + bracedExpr.toString() + ')';
	}
}
