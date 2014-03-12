package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
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
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.Types.NumberType;



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

	@Override
	/**
	 *  Neg expression (BraceExpr does not force a type)
	 *  Returns an error if its child is of type numbertype
	 */
	public List<QLErrorMsg> visit(NegExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		if (expr.getExpr().getType() == new NumberType()) {
			msgs.add(new QLErrorMsg("Expression contains invalid types: " + expr));
		}
		
		return msgs;
	}
	
	
	// logical expressions
	@Override
	public List<QLErrorMsg> visit(AndExpr expr) {
		return this.checkBoolChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(OrExpr expr) {
		return this.checkBoolChilds(expr);
	}
	
	// mathematical expressions
	@Override
	public List<QLErrorMsg> visit(MultExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(DivExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(PlusExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(MinExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	// relational expressions
	@Override
	public List<QLErrorMsg> visit(GeqExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(GreExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(LeqExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	@Override
	public List<QLErrorMsg> visit(LesExpr expr) {
		return this.checkNumberChilds(expr);
	}
	
	/**
	 * Given a binary expression, this function will return an 
	 * error message if the children are not boolean type
	 */
	private List<QLErrorMsg> checkBoolChilds(BinaryExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		boolean correctType = (
				expr.getLHS().getType() == new BoolType()
				&& expr.getRHS().getType() == new BoolType()
				);
		
		if (!correctType) {
			msgs.add(new QLErrorMsg("Expression contains invalid types: " + expr));
		}
		
		return msgs;
	}
	
	
	/**
	 * Given a binary expression, this function will return an 
	 * error message if the children are not number type
	 */
	private List<QLErrorMsg> checkNumberChilds(BinaryExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		boolean correctType = (
				expr.getLHS().getType() == new NumberType()
				&& expr.getRHS().getType() == new NumberType()
				);
		
		if (!correctType) {
			msgs.add(new QLErrorMsg("Expression contains invalid types: " + expr));
		}
		
		return msgs;
	}
	
}
