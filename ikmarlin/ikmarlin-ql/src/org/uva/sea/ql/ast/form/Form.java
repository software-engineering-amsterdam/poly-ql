package org.uva.sea.ql.ast.form;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Statement;

public class Form {
	private Ident ident;
	private Block stmts;
	
	public Form(Ident ident, Block stmts){
		this.ident = ident;
		this.stmts = stmts;
	}
	
}
