package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqualityExpr;

/**
 * Represents the not equal exression in QL4 AST
 * @author Sammie Katt
 *
 */
public class NeqExpr extends EqualityExpr {

	public NeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Neq(" + super.toString() + ")";
	}
}
