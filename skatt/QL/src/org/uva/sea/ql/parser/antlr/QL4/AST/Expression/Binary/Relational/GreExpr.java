package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiRelationExpr;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Represents the greater than expression in QL4 AST
 * @author Sammie Katt
 *
 */
public class GreExpr extends BiRelationExpr {

	public GreExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "Gre(" + super.toString() + ")";
	}
}
