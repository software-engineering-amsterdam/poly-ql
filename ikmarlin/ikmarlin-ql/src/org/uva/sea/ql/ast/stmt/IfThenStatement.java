package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThenStatement extends ConditionalQuestion {
	
	public IfThenStatement(Expr condition, Block body) {
		super(condition, body);
	}
	
}