package org.uva.sea.ql.ast.statement;


public interface IVisitor {
	
	void visit(ExpressionQuestion exprquestion);
	void visit(Question question);
	void visit(IfStatement ifconditional);
	void visit(IfElseStatement ifelseconditional);
	void visit(Form form);
	void visit(Questions questionset);
}
