package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Represents the relational expression ( > < => etc) in QL AST
 * @author Sammie Katt
 *
 */
public abstract class BiRelationExpr extends BinaryExpr {

	public BiRelationExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new BoolType();
	}
}