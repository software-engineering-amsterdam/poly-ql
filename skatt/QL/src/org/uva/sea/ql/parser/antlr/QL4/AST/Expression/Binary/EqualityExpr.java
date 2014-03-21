package org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Abstract class for eqExpr and neqExpr (a parent class for
 * all expressions that handle either is equal to or 
 * is not equal to). Contains required constructor
 * @author Sammie Katt
 *
 */
public abstract class EqualityExpr extends BinaryExpr {

	public EqualityExpr(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type getType(Map<Identifier, Question> questions) {
		return new BoolType();
	}
}
