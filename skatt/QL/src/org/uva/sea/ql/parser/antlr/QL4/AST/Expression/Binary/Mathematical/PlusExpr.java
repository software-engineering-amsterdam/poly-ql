package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents a plus expression in the QL4 AST
 * @author Sammie Katt
 *
 */
public class PlusExpr extends BiMathExpr {

	public PlusExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Add(" + super.toString() + ")";
	}
}
