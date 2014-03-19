package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;

public class IfElseStatement extends Statement {

	private final Expression conditional;
	private final Questions ifBody;
	private final Questions elseBody;
	
	public IfElseStatement(Expression expr, Questions ifBody, Questions elseBody) {
		this.conditional = expr;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expression getConditional(){
		return this.conditional;
	}

	public Questions getIfBody(){
		return this.ifBody;
	}
	
	public Questions getElseBody(){
		return this.elseBody;
	}
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);		
	}

}
