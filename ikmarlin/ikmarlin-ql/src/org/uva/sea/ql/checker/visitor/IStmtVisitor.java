package org.uva.sea.ql.checker.visitor;

import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;

public interface IStmtVisitor {
	
	public void visit(AnswerableQuestion stmt);
	public void visit(ComputedQuestion stmt);
	public void visit(IfThenStatement stmt);
	public void visit(IfThenElseStatement stmt);
	public void visit(Block stmt);

}
