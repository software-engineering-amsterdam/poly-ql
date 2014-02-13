package org.uva.sea.ql.ast.statement;

public interface IStatementVisitor {
	
	void visit(ExprQuestion exprquestion);
	void visit(Question question);
	void visit(If ifconditional);
	void visit(IfElse ifelseconditional);
	void visit(Form form);
	void visit(QuestionSet questionset);

}
