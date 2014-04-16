package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;
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
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new BoolType();
	}
	
	public String toString() {
		return "Not(" + super.toString() + ")";
	}
}
