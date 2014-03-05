package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.QL4Expression;

/**
 * Abstract class for all binair expressions. Contains a lhs and rhs
 * of the expression and a constructor for setting them.
 * @author Sammie Katt
 *
 */
public abstract class QL4BinairExpr extends QL4Expression {
	/**
	 * The left hand and right hand side of the binair expression
	 */
	QL4Tree lhs;
	QL4Tree rhs;
	
	public QL4BinairExpr(QL4Tree lhs, QL4Tree rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
