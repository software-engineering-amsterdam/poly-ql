package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;

/**
 * Represents and expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class AndExpr extends BinaryExpr {

	public AndExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	public String toString() {
		return "And(" + super.toString() + ")";
	}

}
