package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;

/**
 * Represents a braced expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class BraceExpr extends UnaryExpr {

	public BraceExpr(Expression expr) {
		super(expr);
	}
	
	public String toString() {
		return '(' + super.toString() + ')';
	}
}
