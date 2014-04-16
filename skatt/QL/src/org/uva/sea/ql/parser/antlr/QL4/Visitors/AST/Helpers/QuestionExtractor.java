package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
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
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * While visiting a form, this visitor will maintain a map of 
 * identifier -> question
 * and return this eventually.
 * @author Sammie Katt
 *
 */
public class QuestionExtractor implements IQLVisitor<Map<Identifier, Question>> {

	@Override
	public Map<Identifier, Question> visit(Form form) {
		return visitChild(form.getStructures());
	}

	@Override
	public Map<Identifier, Question> visit(Question question) {
		Map<Identifier, Question> questions = new HashMap<Identifier, Question>(); 
		
		questions.put(question.getIdentifier(), question);

		return questions;
	}

	@Override
	public Map<Identifier, Question> visit(Structures struc) {
		Map<Identifier, Question> questions = new HashMap<Identifier, Question>(); 
		List<QLTree> structures = struc.getStructures();
		
		for (QLTree structure : structures) {
			questions.putAll(visitChild(structure));
		}
		
		return questions;
	}

	@Override
	public Map<Identifier, Question> visit(ConditionalStructure condition) {
		Map<Identifier, Question> questions = new HashMap<Identifier, Question>();
		
		questions.putAll(this.visitChild(condition.getIfStructures()));
		
		List<Structures> elseIfStructs = condition.getElseIfStructs();
		
		// loop over all elseif expressions and structures
		for (QLTree struc : elseIfStructs) {
			questions.putAll(this.visitChild(struc));
		}
		
		questions.putAll(this.visitChild(condition.getElseStruct()));
		
		return questions;
	}

	///////////// ignore expressions
	
	@Override
	public Map<Identifier, Question> visit(BraceExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NegExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(GeqExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(GreExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(LeqExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(LesExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(PlusExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(MinExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(DivExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(MultExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(AndExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(OrExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(EqExpr expr) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NeqExpr expr) {
		return null;
	}

	/////////////// ignore values 
	
	@Override
	public Map<Identifier, Question> visit(Identifier id) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Bool bool) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Decimal dec) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Label label) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(Number number) {
		return null;
	}
	

	@Override
	public Map<Identifier, Question> visit(Text text) {
		return null;
	}
	
	@Override
	public Map<Identifier, Question> visit(NullValue nullValue) {
		return null;
	}

	

	///////////////// ignore types
	
	@Override
	public Map<Identifier, Question> visit(BoolType boolType) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(NumberType boolType) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(DateType dateType) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(CurrencyType currencyType) {
		return null;
	}

	@Override
	public Map<Identifier, Question> visit(StringType stringType) {
		return null;
	}
	
	@Override
	public Map<Identifier, Question> visit(NullType nullType) {
		return null;
	}

	/**
	 * Private function for visiting anything: provides desired
	 * behavior for when either the child or its input is null
	 */
	public Map<Identifier, Question> visitChild(QLTree child) {
		Map<Identifier, Question> questions = null; 
		
		// if child is not null, visit
		if(child != null) {
			questions = child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (questions == null) {
			questions = new HashMap<Identifier, Question>();
		}
		
		return questions;
	}
}
