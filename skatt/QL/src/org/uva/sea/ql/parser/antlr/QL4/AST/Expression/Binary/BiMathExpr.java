package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;

/**
 * Abstract class for all mathematical, binary expressions in QL AST.
 * contains a constructor, as binaryExpr (which it extends) requires one. 
 * @author Sammie Katt
 *
 */
public abstract class BiMathExpr extends BinaryExpr {

	public BiMathExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new NumberType();
	}
}
