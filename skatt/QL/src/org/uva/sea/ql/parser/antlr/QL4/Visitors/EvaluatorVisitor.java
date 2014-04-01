package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.Map;

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
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.NullValue;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;

/**
 * Evaluates the QL4 expressions it visits
 * @author Sammie Katt
 */
public class EvaluatorVisitor implements IQLVisitor<Value> {

	// when visiting, the identifier and their values are necessary
	Map<Identifier, Question> env;
	
	public EvaluatorVisitor(Map<Identifier, Question> env) {
		this.env = env;
	}
	
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
		return expr.getExpr().accept(this);
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
		if (env.containsKey(id)) {
			return env.get(id).accept(this);
		} else {
			return new NullValue();
		}
	}

	/**
	 * visiting values: return whatever visited
	 */
	@Override
	public Value visit(Bool bool) {
		return bool;
	}

	@Override
	public Value visit(Decimal dec) {
		return dec;
	}

	@Override
	public Value visit(Text text) {
		return text;
	}
	
	@Override
	public Value visit(Number number) {
		return number;
	}
	
	@Override
	public Value visit(NullValue nullValue) {
		return nullValue;
	}
	
	/**
	 * No evaluating label or types: return null
	 */

	@Override
	public Value visit(Label label) {
		return null;
	}

	@Override
	public Value visit(BoolType boolType) {
		return null;

	}
	
	@Override
	public Value visit(NumberType numberType) {
		return null;
	}

	@Override
	public Value visit(DateType dateType) {
		return null;
	}

	@Override
	public Value visit(CurrencyType currencyType) {
		return null;
	}

	@Override
	public Value visit(NullType nullType) {
		return null;
	}

	@Override
	public Value visit(StringType stringType) {
		return null;
	}
}
