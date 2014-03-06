package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

public class QLVisitor implements QLIVisitor {

	@Override
	public List<QLErrorMsg> visit(QLTree tree) {
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Form form) {
		System.out.println(form.getClass().getName());
		return null;
	}

	@Override
	public List<QLErrorMsg> visit(Question question) {
		return null;
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

}
