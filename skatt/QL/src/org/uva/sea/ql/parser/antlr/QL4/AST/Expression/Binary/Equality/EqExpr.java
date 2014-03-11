package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqualityExpr;

/**
 * Represents Equality expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class EqExpr extends EqualityExpr {

	public EqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Eq(" + super.toString() + ")";
	}
}
