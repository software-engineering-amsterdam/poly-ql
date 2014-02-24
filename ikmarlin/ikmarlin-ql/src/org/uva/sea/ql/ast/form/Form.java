package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmt.Block;

public class Form {
	private Ident ident;
	private Block stmts;
	
	public Form(Ident ident, Block stmts){
		this.ident = ident;
		this.stmts = stmts;
	}
	
	public Block getBlock(){
		return this.stmts;
	}
	
}
