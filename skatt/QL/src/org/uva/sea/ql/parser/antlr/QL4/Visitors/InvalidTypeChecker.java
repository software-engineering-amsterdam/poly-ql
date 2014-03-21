package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Checks whether the type of expressions in operators are
 * appropriate, otherwise returns a (list of) error(s).
 *
 * Note: equality expressions are ignored, as they simply
 * will produce a false. Similary BraceExpr is not checked
 * 
 * @author Sammie Katt
 *
 */
public class InvalidTypeChecker extends QLErrorVisitor {
	
	private Map<Identifier, Question> questions;
	
	public InvalidTypeChecker(Map<Identifier, Question> questions) {
		this.questions = questions;
	}

	@Override
	/**
	 *  Neg expression (BraceExpr does not force a type)
	 *  Returns an error if its child is of type numbertype
	 */
	public List<QLErrorMsg> visit(NegExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		if (expr.getExpr().getType(questions) == new NumberType()) {
			msgs.add(new QLErrorMsg("Expression contains invalid types: " + expr));
		}
		
		msgs.addAll(this.visitChild(expr.getExpr()));
		
		return msgs;
	}
	
	
	// logical expressions
	@Override
	public List<QLErrorMsg> visit(AndExpr expr) {
		return this.checkChildsType(expr, new BoolType());
	}
	
	@Override
	public List<QLErrorMsg> visit(OrExpr expr) {
		return this.checkChildsType(expr, new BoolType());
	}
	
	// mathematical expressions
	@Override
	public List<QLErrorMsg> visit(MultExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(DivExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(PlusExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(MinExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	// relational expressions
	@Override
	public List<QLErrorMsg> visit(GeqExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(GreExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(LeqExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	@Override
	public List<QLErrorMsg> visit(LesExpr expr) {
		return this.checkChildsType(expr, new NumberType());
	}
	
	/**
	 * Given a binary expression and an expected type, this function will return an 
	 * error message if the children is not of expected type
	 */
	private List<QLErrorMsg> checkChildsType(BinaryExpr expr, Type type) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		boolean correctType = (
				expr.getLHS().getType(questions).equals(type)
				&& expr.getRHS().getType(questions).equals(type)
				);
		
		if (!correctType) {
			msgs.add(new QLErrorMsg("Expression contains invalid types: " + expr));
		}
		
		return msgs;
	}
}
