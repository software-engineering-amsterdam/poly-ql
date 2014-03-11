package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
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
 * @author Sammie Katt
 *
 */
public class InvalidType extends QLErrorVisitor {

	public List<QLErrorMsg> visit(UnaryExpr expr) {
		return null;
	}
	
	public List<QLErrorMsg> visit(BinaryExpr expr) {
		return null;
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
