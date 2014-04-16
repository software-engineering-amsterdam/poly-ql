package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * Represents a braced expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class BraceExpr extends UnaryExpr {

	public BraceExpr(Expression expr) {
		super(expr);
	}
	

	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return this.getExpr().getType(questions);
	}
	
	@Override
	public String toString() {
		return '(' + super.toString() + ')';
	}

}
