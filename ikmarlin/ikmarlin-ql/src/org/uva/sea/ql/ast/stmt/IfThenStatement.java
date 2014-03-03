package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;

public class IfThenStatement extends ConditionalQuestion {
	
	public IfThenStatement(Expr condition, Block body) {
		super(condition, body);
	}

	@Override
	public void accept(IStmtVisitor sv) {
		sv.visit(this);
	}
	
}