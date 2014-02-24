package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.checker.StmtVisitor;

public class ComputedQuestion extends Question {
	
	private Expr computation;

	public ComputedQuestion(Ident ident, String label, Expr type, Expr computation) {
		super(ident, label, type);
		this.setComputation(computation);
	}

	public Expr getComputation() {
		return computation;
	}

	public void setComputation(Expr computation) {
		this.computation = computation;
	}

	@Override
	public void accept(StmtVisitor sv) {
		sv.visit(this);
	}

}
