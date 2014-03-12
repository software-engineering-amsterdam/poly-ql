package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents the not expression in QL AST (!expression)
 * @author Sammie Katt
 *
 */
public class NegExpr extends UnaryExpr {
	public NegExpr(Expression expr) {
		super(expr);
	}
	
	public String toString() {
		return "Not(" + super.toString() + ")";
	}

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
}
