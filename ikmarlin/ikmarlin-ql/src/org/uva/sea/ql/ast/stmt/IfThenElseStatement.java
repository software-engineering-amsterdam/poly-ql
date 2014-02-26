package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThenElseStatement extends ConditionalQuestion {
	
	private Block elseBlock;
	
	public IfThenElseStatement(Expr condition, Block ifBlock, Block elseBlock) {
		super(condition, ifBlock);
		setElseBlock(elseBlock);
	}
	
	public Block getIfBlock(){
		return super.getBody();
	}

	public Block getElseBlock() {
		return elseBlock;
	}

	public void setElseBlock(Block elseBlock) {
		this.elseBlock = elseBlock;
	}
	
}