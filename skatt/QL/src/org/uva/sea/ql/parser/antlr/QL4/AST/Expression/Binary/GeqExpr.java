package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents the greater or equal expression in QL4 AST
 * @author Sammie
 *
 */
public class GeqExpr extends BinaryExpr {

	public GeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "Geq(" + super.toString() + ")";
	}
}
