package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

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

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
}
