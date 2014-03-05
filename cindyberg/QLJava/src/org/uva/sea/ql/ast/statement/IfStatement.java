package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;

public class IfStatement extends Statement{

	private final Expression conditional;
	private final Questions body;
	
	public IfStatement(Expression expr, Questions body) {	
		this.conditional = expr;
		this.body = body;
	}
	
	public Expression getConditional(){
		return this.conditional;
	}
	
	public Questions getIfBody(){
		return this.body;
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}
