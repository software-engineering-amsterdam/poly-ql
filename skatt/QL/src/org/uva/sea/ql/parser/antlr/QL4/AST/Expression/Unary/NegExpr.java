package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.Types.Type;
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

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new BoolType();
	}
	
	public String toString() {
		return "Not(" + super.toString() + ")";
	}
}
