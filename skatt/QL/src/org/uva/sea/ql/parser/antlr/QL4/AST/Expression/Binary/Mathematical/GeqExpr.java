package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;

/**
 * Represents the greater or equal expression in QL4 AST
 * @author Sammie
 *
 */
public class GeqExpr extends BiMathExpr {

	public GeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Geq(" + super.toString() + ")";
	}
}
