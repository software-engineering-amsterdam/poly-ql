package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqualityExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * Represents the not equal exression in QL4 AST
 * @author Sammie Katt
 *
 */
public class NeqExpr extends EqualityExpr {

	public NeqExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Neq(" + super.toString() + ")";
	}
}
