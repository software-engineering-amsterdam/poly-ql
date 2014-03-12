package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Types.BoolType;

/**
 * Visitor for checking whether all conditions are of type
 * boolean.
 * @author Sammie Katt
 *
 */
public class BoolConditionChecker extends QLErrorVisitor {
	
	/**
	 * When visiting a conditional structure, check whether its
	 * if/else expression are of type boolean and visit the each structure
	 */
	@Override
	public List<QLErrorMsg> visit(ConditionalStructure condition) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();

		// check whether if statement is of type boolean
		msgs.add(checkExpression(condition.getIfExpression()));
		
		// regular (overridden) function for visiting
		msgs.addAll(this.visitChild(condition.getIfExpression()));
		msgs.addAll(this.visitChild(condition.getIfStructures()));
		
		List<Expression> elseIfExprs = condition.getElseIfExpr();
		List<Structures> elseIfStructs = condition.getElseIfStructs();
		
		// loop over all elseif expressions and structures
		for (int i = 0; i < elseIfExprs.size(); i++) {
			msgs.add(checkExpression(elseIfExprs.get(i))); // check expression for boolean type
			msgs.addAll(this.visitChild(elseIfExprs.get(i)));
			msgs.addAll(this.visitChild(elseIfStructs.get(i)));
		}
		
		msgs.addAll(this.visitChild(condition.getElseStruct()));
		
		
		return msgs;
	}
	
	/**
	 * Returns a QLError if expression is not of type BoolType, otherwise
	 * returns null.
	 */
	private QLErrorMsg checkExpression(Expression expr) {
		if (expr.getType().equals(new BoolType())) {
			return new QLErrorMsg("Expression " + expr + " does not return a boolean");
		} else {
			return null;
		}
	}
}

