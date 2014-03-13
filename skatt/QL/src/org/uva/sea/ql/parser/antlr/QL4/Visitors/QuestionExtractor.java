package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GreExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LesExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.CurrencyType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.DateType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;

/**
 * While visiting a form, this visitor will maintain a map of 
 * identifier -> question
 * and return this eventually.
 * @author Sammie
 *
 */
public class QuestionExtractor implements IQLVisitor<Map<Identifier, Question>> {

	@Override
	public Map<Identifier, Question> visit(Form form) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Structures struc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(ConditionalStructure condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(BraceExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NegExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(GeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(GreExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(LeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(LesExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(PlusExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(MinExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(DivExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(MultExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(AndExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(OrExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(EqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Identifier id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Bool bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Decimal dec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Label label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(BoolType boolType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NumberType boolType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(DateType dateType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(CurrencyType currencyType) {
		// TODO Auto-generated method stub
		return null;
	}

}
