package org.uva.sea.ql.ast.stat;

import java.util.ArrayList;

public class Block extends Statement {
	
	private ArrayList<Statement> stmts;
	
	public Block(){
		this.stmts = new ArrayList<Statement>();
	}
	
	public void addStmt(Statement stmt){
		this.stmts.add(stmt);
	}
}
