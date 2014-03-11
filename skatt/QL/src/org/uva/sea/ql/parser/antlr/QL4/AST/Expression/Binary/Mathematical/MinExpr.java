package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;

/**
 * Represents a min expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class MinExpr extends BiMathExpr {

	public MinExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Min(" + super.toString() + ")";
	}
}
