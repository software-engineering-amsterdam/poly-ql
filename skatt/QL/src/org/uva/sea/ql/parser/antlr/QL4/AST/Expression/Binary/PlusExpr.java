package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents a plus expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class PlusExpr extends BinaryExpr{

	public PlusExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Add(" + super.toString() + ")";
	}
}
