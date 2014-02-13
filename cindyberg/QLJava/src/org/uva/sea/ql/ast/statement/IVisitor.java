package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.statement.ExprQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.IfElse;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionSet;

public interface IVisitor {
	
	void visit(ExprQuestion exprquestion);
	void visit(Question question);
	void visit(If ifconditional);
	void visit(IfElse ifelseconditional);
	void visit(Form form);
	void visit(QuestionSet questionset);

}
