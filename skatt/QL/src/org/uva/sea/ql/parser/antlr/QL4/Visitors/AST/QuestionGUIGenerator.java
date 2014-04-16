package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.CurrencyType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.DateType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NullType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.StringType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.NullValue;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;
import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question.QuestionElement;
import org.uva.sea.ql.parser.antlr.QL4.GUI.Elements.Question.RegularQuestionElement;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.Visitor;

/**
 * Renders form: extracts questions and returns a list of them rendered as questions
 * @author Sammie Katt
 */
public class QuestionGUIGenerator extends Visitor implements IQLVisitor<List<QuestionElement>>{

	/**
	 * Each visited child is handled through this function
	 * Conducts checks on null
	 */
	private List<QuestionElement> visitChild(QLTree child) {
		List<QuestionElement> questions = null; 
		
		// if child is not null, visit
		if(child != null) {
			questions = child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (questions == null) {
			questions = new ArrayList<QuestionElement>();
		}
		
		return questions;
	}
	
	/**
	 * Visit functions. Visits all higher level nodes:
	 * - form
	 * - structures
	 * - conditional structure
	 * - questions
	 */
	@Override
	public List<QuestionElement> visit(Form form) {
		return visitChild(form.getStructures());
	}

	@Override
	public List<QuestionElement> visit(Question question) {
		List<QuestionElement> questionContainer = new ArrayList<QuestionElement>();
		javafx.scene.control.Label label = new javafx.scene.control.Label(question.getLabel().toString());
		Type type = question.getType();
		Identifier id = question.getIdentifier();
		
		QuestionElement questionGUI = new RegularQuestionElement(label, type, id);
		
		questionContainer.add(questionGUI);
		
		return questionContainer;
	}

	@Override
	public List<QuestionElement> visit(Structures struc) {
		List<QuestionElement> questions = new ArrayList<QuestionElement>();
		List<QLTree> structures = struc.getStructures();

		// gather questions from all structures
		for (QLTree structure : structures) {
			questions.addAll(this.visitChild(structure));
		}
		
		return questions;
	}

	@Override
	public List<QuestionElement> visit(ConditionalStructure condition) {
		List<QuestionElement> questions = new ArrayList<QuestionElement>();
		
		questions.addAll(this.visitChild(condition.getIfExpression()));
		questions.addAll(this.visitChild(condition.getIfStructures()));
		
		List<Expression> elseIfExprs = condition.getElseIfExpr();
		List<Structures> elseIfStructs = condition.getElseIfStructs();
		
		// loop over all elseif expressions and structures
		for (int i = 0; i < elseIfExprs.size(); i++) {
			questions.addAll(this.visitChild(elseIfExprs.get(i)));
			questions.addAll(this.visitChild(elseIfStructs.get(i)));
		}
		
		questions.addAll(this.visitChild(condition.getElseStruct()));
		
		return questions;
	}

	/*
	 * Other visits return null
	 */
	@Override
	public List<QuestionElement> visit(BraceExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(NegExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(GeqExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(GreExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(LeqExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(LesExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(PlusExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(MinExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(DivExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(MultExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(AndExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(OrExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(EqExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(NeqExpr expr) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Identifier id) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Bool bool) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Decimal dec) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Label label) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Number number) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(NullValue nullValue) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(BoolType boolType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(NumberType numberType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(DateType dateType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(CurrencyType currencyType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(NullType nullType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(StringType stringType) {
		return null;
	}

	@Override
	public List<QuestionElement> visit(Text text) {
		return null;
	}

}
