package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;

public interface StmtVisitor {
	
	public void visit(AnswerableQuestion stmt);
	public void visit(ComputedQuestion stmt);
	public void visit(ConditionalQuestion stmt);
	public void visit(Block stmt);
	public void visit(Form stmt);

}
