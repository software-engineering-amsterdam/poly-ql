package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;

/**
 * Represents the less than expression in QL4 AST
 * @author Sammie
 *
 */
public class LesExpr extends BiMathExpr {

	public LesExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Les(" + super.toString() + ")";
	}
}
