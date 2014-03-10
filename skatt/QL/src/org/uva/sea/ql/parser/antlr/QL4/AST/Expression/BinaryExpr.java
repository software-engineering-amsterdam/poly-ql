package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;


/**
 * Abstract class for all binair expressions. Contains a lhs and rhs
 * of the expression and a constructor for setting them.
 * @author Sammie Katt
 *
 */
public abstract class BinaryExpr extends Expression {
	/**
	 * The left hand and right hand side of the binair expression
	 */
	private final Expression lhs;
	private final Expression rhs;
	
	public BinaryExpr(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return lhs.toString() + ", " + rhs.toString();
	}
	
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}

	public Expression getLHS() {
		return lhs;
	}
	
	public Expression getRHS() {
		return rhs;
	}
}
