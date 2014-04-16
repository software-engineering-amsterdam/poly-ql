package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Abstract class for all logical, binary expressions in QL AST.
 * contains a constructor, as binaryExpr (which it extends) requires one. 
 * @author Sammie Katt
 *
 */
public abstract class BiLogicExpr extends BinaryExpr {

	public BiLogicExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new BoolType();
	}
}
