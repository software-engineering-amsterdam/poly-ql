package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiRelationExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents the less than expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class LesExpr extends BiRelationExpr {

	public LesExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Les(" + super.toString() + ")";
	}
}
