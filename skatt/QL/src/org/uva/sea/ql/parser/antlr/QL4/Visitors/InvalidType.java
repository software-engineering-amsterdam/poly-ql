package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiLogicExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqualityExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;


/**
 * Checks whether the type of expressions in operators are
 * appropriate, otherwise returns a (list of) error(s).
 * 
 * Note: Of the binary operations, it will not override the default
 * visiting behavior of the equalityExpr. Equality can be tested
 * between different types, as it will simply return false. 
 * 
 * @author Sammie Katt
 *
 */
public class InvalidType extends QLErrorVisitor {

	/**
	 * TODO: visit unary expr
	 */

	/**
	 * TODO: Visit question identifier or question
	 */
	
	/**
	 * If visiting a mathematical expression, check whether
	 * both its lhs and rhs are mathematical.
	 */
	@Override
	public List<QLErrorMsg> visit(BiMathExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		// generate warning if not both hand sides are mathematical
		if (! (isMathematical(expr.getLHS()) && isMathematical(expr.getRHS()) ) ) {
			msgs.add(new QLErrorMsg("Cannot perform " + expr));
		}
		
		// add errors and warnings from childs
		msgs.addAll(visitChild(expr.getLHS()));
		msgs.addAll(visitChild(expr.getRHS()));
		
		return msgs;
	}
	
	/**
	 * If visiting a logical expression, check whether
	 * both its lhs and rhs are logical.
	 */
	@Override
	public List<QLErrorMsg> visit(BiLogicExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		// generate warning if not both hand sides are logical
		if (! (isLogical(expr.getLHS()) && isLogical(expr.getRHS()) ) ) {
			msgs.add(new QLErrorMsg("Cannot perform " + expr));
		}
		
		// add errors and warnings from childs
		msgs.addAll(visitChild(expr.getLHS()));
		msgs.addAll(visitChild(expr.getRHS()));
		
		return msgs;
	}
	
	/**
	 * Checks whether the class of input is:
	 * a decimal OR
	 * a number OR
	 * a subclass of BiMathExpr OR
	 * a subclass of equalityExpr OR
	 * a BraceExpr
	 */
	private boolean isMathematical(Expression expr) {
		return (
				expr instanceof Decimal
				|| expr instanceof Number
				|| BiMathExpr.class.isAssignableFrom(expr.getClass())
				|| EqualityExpr.class.isAssignableFrom(expr.getClass())
				|| expr instanceof BraceExpr
				);
	}
	
	/**
	 * Checks whether the class of input is:
	 * a Boolean
	 * a subclass of BiLogicExpr OR
	 * a subclass of equalityExpr OR
	 * a subclass of unaryExpr
	 */
	private boolean isLogical(Expression expr) {
		return (
				expr instanceof Bool
				|| BiLogicExpr.class.isAssignableFrom(expr.getClass())
				|| EqualityExpr.class.isAssignableFrom(expr.getClass())
				|| UnaryExpr.class.isAssignableFrom(expr.getClass())
				);
	}
}
