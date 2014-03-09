package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Parent of all Error visitor classes. Implements the default
 * behavior of visiting: return the error msgs of children.
 * @author Sammie Katt
 *
 */
public class QLErrorVisitor implements IQLVisitor {

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
	public List<QLErrorMsg> visit(Conditional condition) {
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

	@Override
	public List<QLErrorMsg> visit(UnaryExpr expr) {
		return this.visitChild(expr.getExpr());
	}

	@Override
	public List<QLErrorMsg> visit(BinaryExpr expr) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		msgs.addAll(this.visitChild(expr.getLHS()));
		msgs.addAll(this.visitChild(expr.getRHS()));
		
		return msgs;
	}

	/**
	 * No children to visit in value
	 */
	@Override
	public List<QLErrorMsg> visit(Value expr) {
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
			msgs = child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (msgs == null) {
			msgs = new ArrayList<QLErrorMsg>();
		}
		
		return msgs;
	}
}
