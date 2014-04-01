package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiRelationExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents the Less or equal to expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class LeqExpr extends BiRelationExpr {

	public LeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Leq(" + super.toString() + ")";
	}
}
