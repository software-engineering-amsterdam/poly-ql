package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NullType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.StringType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;

/**
 * Evaluates the QL4 expressions it visits
 * @author Sammie Katt
 */
public class EvaluatorVisitor implements IQLVisitor<Value> {

	/**
	 * Ignore all non-expression when visiting
	 */
	
	@Override
	public Value visit(Form form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Structures struc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(ConditionalStructure condition) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Unary expressions 
	 */
	
	@Override
	public Value visit(BraceExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NegExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GreExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LesExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(PlusExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(MinExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(DivExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(MultExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(AndExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(OrExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(EqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NeqExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Identifier id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Bool bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Decimal dec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Label label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Number number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(BoolType boolType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NumberType numberType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(DateType dateType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(CurrencyType currencyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NullType nullType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(StringType stringType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Text text) {
		// TODO Auto-generated method stub
		return null;
	}

}
