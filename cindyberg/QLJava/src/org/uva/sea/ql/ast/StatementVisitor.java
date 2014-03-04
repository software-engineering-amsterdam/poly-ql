package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionSet;

public interface StatementVisitor {

	 void visit(ExpressionQuestion exprquestion);
	 void visit(Question question);
	 void visit(IfStatement ifconditional);
	 void visit(IfElseStatement ifelseconditional);
	 void visit(Form form);
	 void visit(QuestionSet questionset);
}
