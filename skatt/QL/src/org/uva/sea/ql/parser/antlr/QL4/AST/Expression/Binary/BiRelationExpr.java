package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;

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