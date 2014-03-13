package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents a multiplication expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class MultExpr extends BiMathExpr {

	public MultExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Mult(" + super.toString() + ")";
	}
}
