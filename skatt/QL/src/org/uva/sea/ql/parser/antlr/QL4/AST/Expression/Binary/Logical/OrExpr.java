package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiLogicExpr;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents or expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class OrExpr extends BiLogicExpr {

	public OrExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Or(" + super.toString() + ")";
	}
}
