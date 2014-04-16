package org.uva.sea.ql.parser.antlr.QL4.GUI.Visitors;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import org.uva.sea.ql.parser.antlr.QL4.Visitor;
import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
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
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Renders form: extracts questions and returns a list of them rendered as hboxes
 * @author Sammie Katt
 */
public class Renderer extends Visitor implements IQLVisitor<List<HBox>>{

	/**
	 * Each visited child is handled through this function
	 * Conducts checks on null
	 */
	private List<HBox> visitChild(QLTree child) {
		List<HBox> hboxes = null; 
		
		// if child is not null, visit
		if(child != null) {
			hboxes = child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (hboxes == null) {
			hboxes = new ArrayList<HBox>();
		}
		
		return hboxes;
	}
	
	/**
	 * Visit functions. Visits all higher level nodes:
	 * - form
	 * - structures
	 * - conditional structure
	 * - questions
	 */
	@Override
	public List<HBox> visit(Form form) {
		return visitChild(form.getStructures());
	}

	@Override
	public List<HBox> visit(Question question) {
		List<HBox> questionContainer = new ArrayList<HBox>();
		HBox questionGUI = new HBox();
		
		questionGUI.getChildren().add(new javafx.scene.control.Label(question.getLabel().toString()));
		questionGUI.getChildren().add(new TextField());
		questionContainer.add(questionGUI);
		
		return questionContainer;
	}

	@Override
	public List<HBox> visit(Structures struc) {
		List<HBox> hboxes = new ArrayList<HBox>();
		List<QLTree> structures = struc.getStructures();

		// gather hboxes from all structures
		for (QLTree structure : structures) {
			hboxes.addAll(this.visitChild(structure));
		}
		
		return hboxes;
	}

	@Override
	public List<HBox> visit(ConditionalStructure condition) {
		List<HBox> hboxes = new ArrayList<HBox>();
		
		hboxes.addAll(this.visitChild(condition.getIfExpression()));
		hboxes.addAll(this.visitChild(condition.getIfStructures()));
		
		List<Expression> elseIfExprs = condition.getElseIfExpr();
		List<Structures> elseIfStructs = condition.getElseIfStructs();
		
		// loop over all elseif expressions and structures
		for (int i = 0; i < elseIfExprs.size(); i++) {
			hboxes.addAll(this.visitChild(elseIfExprs.get(i)));
			hboxes.addAll(this.visitChild(elseIfStructs.get(i)));
		}
		
		hboxes.addAll(this.visitChild(condition.getElseStruct()));
		
		return hboxes;
	}

	/*
	 * Other visits return null
	 */
	@Override
	public List<HBox> visit(BraceExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(NegExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(GeqExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(GreExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(LeqExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(LesExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(PlusExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(MinExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(DivExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(MultExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(AndExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(OrExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(EqExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(NeqExpr expr) {
		return null;
	}

	@Override
	public List<HBox> visit(Identifier id) {
		return null;
	}

	@Override
	public List<HBox> visit(Bool bool) {
		return null;
	}

	@Override
	public List<HBox> visit(Decimal dec) {
		return null;
	}

	@Override
	public List<HBox> visit(Label label) {
		return null;
	}

	@Override
	public List<HBox> visit(Number number) {
		return null;
	}

	@Override
	public List<HBox> visit(NullValue nullValue) {
		return null;
	}

	@Override
	public List<HBox> visit(BoolType boolType) {
		return null;
	}

	@Override
	public List<HBox> visit(NumberType numberType) {
		return null;
	}

	@Override
	public List<HBox> visit(DateType dateType) {
		return null;
	}

	@Override
	public List<HBox> visit(CurrencyType currencyType) {
		return null;
	}

	@Override
	public List<HBox> visit(NullType nullType) {
		return null;
	}

	@Override
	public List<HBox> visit(StringType stringType) {
		return null;
	}

	@Override
	public List<HBox> visit(Text text) {
		return null;
	}

}
