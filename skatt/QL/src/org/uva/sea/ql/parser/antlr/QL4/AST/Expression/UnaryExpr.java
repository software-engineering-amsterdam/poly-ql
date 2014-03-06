package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.QLIVisitor;


/**
 * Abstract class for all unary expressions (braces and ! operator). 
 * Contains a single expression and a constructor.
 * 
 * @author Sammie Katt
 *
 */
public abstract class UnaryExpr extends Expression {

	final private Expression expr;
	
	public UnaryExpr(Expression expr) {
		this.expr = expr;
	}
	
	public String toString() {
		return expr.toString();
	}
	
	public List<QLErrorMsg> accept(QLIVisitor visitor) {
		return visitor.visit(this);
	}
}
