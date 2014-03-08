package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Parent of all visitor classes. Implements the default
 * behavior of visiting: visiting their children.
 * @author Sammie
 *
 */
public class QLVisitor implements IQLVisitor {

	@Override
	public List<QLErrorMsg> visit(Form form) {
		return form.getStructures().accept(this);
	}

	@Override
	public List<QLErrorMsg> visit(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		msgs.addAll(question.getIdentifier().accept(this));
		msgs.addAll(question.getLabel().accept(this));
		msgs.addAll(question.getType().accept(this));
		msgs.addAll(question.getValue().accept(this));
		
		return msgs;
	}

	@Override
	public List<QLErrorMsg> visit(Structures struc) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Conditional condition) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(UnaryExpr expr) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(BinaryExpr expr) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Value expr) {
		return null;
	}

}
