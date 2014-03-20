package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Parent of all Error visitor classes. Implements the default
 * behavior of visiting: return the error msgs of children.
 * @author Sammie Katt
 *
 */
public class QLErrorVisitor implements IQLVisitor<List<QLErrorMsg>> {

	@Override
	public List<QLErrorMsg> visit(Form form) {
		return this.visitChild(form.getStructures());
	}

	@Override
	public List<QLErrorMsg> visit(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		msgs.addAll(this.visitChild(question.getIdentifier()));
		msgs.addAll(this.visitChild(question.getLabel()));
		msgs.addAll(this.visitChild(question.getType()));
		msgs.addAll(this.visitChild(question.getValue()));
		return msgs;
	}

	@Override
	public List<QLErrorMsg> visit(Structures struc) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		List<QLTree> structures = struc.getStructures();

		// loop over all structure children of a structures
		for (QLTree structure : structures) {
			msgs.addAll(this.visitChild(structure));
		}
		
		return msgs;
	}

	@Override
	public List<QLErrorMsg> visit(ConditionalStructure condition) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		msgs.addAll(this.visitChild(condition.getIfExpression()));
		msgs.addAll(this.visitChild(condition.getIfStructures()));
		
		List<Expression> elseIfExprs = condition.getElseIfExpr();
		List<Structures> elseIfStructs = condition.getElseIfStructs();
		
		// loop over all elseif expressions and structures
		for (int i = 0; i < elseIfExprs.size(); i++) {
			msgs.addAll(this.visitChild(elseIfExprs.get(i)));
			msgs.addAll(this.visitChild(elseIfStructs.get(i)));
		}
		
		msgs.addAll(this.visitChild(condition.getElseStruct()));
		
		return msgs;
	}

	//////////// unary expressions 
	
	@Override
	public List<QLErrorMsg> visit(BraceExpr expr) {
		return this.visitChild(expr.getExpr());
	}

	@Override
	public List<QLErrorMsg> visit(NegExpr expr) {
		return this.visitChild(expr.getExpr());
	}

	/////////// binary expressions
	@Override
	public List<QLErrorMsg> visit(GeqExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(GreExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(LeqExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(LesExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(PlusExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(MinExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(DivExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(MultExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(AndExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(OrExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(EqExpr expr) {
		return this.visitBinaryExpression(expr);
	}

	@Override
	public List<QLErrorMsg> visit(NeqExpr expr) {
		return this.visitBinaryExpression(expr);
	}
	/**
	 * No children to visit when visiting value subclasses
	 */
	
	@Override
	public List<QLErrorMsg> visit(Identifier id) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Bool bool) {
		return null;
	}
	
	@Override
	public List<QLErrorMsg> visit(Decimal dec) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Label label) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Number number) {
		return null;
	}


	@Override
	public List<QLErrorMsg> visit(Text text) {
		return null;
	}
	
	
	@Override
	public List<QLErrorMsg> visit(BoolType boolType) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(NumberType boolType) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(DateType dateType) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(CurrencyType currencyType) {
		return null;
	}
	
	@Override
	public List<QLErrorMsg> visit(StringType stringType) {
		return null;
	}
	
	@Override
	public List<QLErrorMsg> visit(NullType nullType) {
		return null;
	}

	/**
	 * Whenever children are visited, one should check
	 * whether the children themselves are not null,
	 * and neither their return
	 * @param child
	 * @return
	 */
	public List<QLErrorMsg> visitChild(QLTree child) {
		List<QLErrorMsg> msgs = null; 
		
		// if child is not null, visit
		if(child != null) {
			msgs = (List<QLErrorMsg>) child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (msgs == null) {
			msgs = new ArrayList<QLErrorMsg>();
		}
		
		return msgs;
	}
	
	/**
	 * Whenever a binary expression is visited, return the error messages
	 * in both sides of the expression
	 * 
	 */
	public List<QLErrorMsg> visitBinaryExpression(BinaryExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		msgs.addAll(this.visitChild(expr.getLHS()));
		msgs.addAll(this.visitChild(expr.getRHS()));
		
		return msgs;
	}

	
}
