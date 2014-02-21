package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.stmt.*;

public interface StmtVisitor {
	
	public void visit(AnswerableQuestion stmt);
	public void visit(ComputedQuestion stmt);
	public void visit(ConditionalQuestion stmt);
	public void visit(Block stmt);

}
