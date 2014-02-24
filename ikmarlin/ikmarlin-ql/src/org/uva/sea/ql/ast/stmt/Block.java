package org.uva.sea.ql.ast.stmt;

import java.util.ArrayList;

import org.uva.sea.ql.checker.StmtVisitor;

public class Block extends Stmt {
	
	private ArrayList<Stmt> stmts;
	
	public Block(){
		this.stmts = new ArrayList<Stmt>();
	}
	
	public void addStmt(Stmt stmt){
		this.stmts.add(stmt);
	}
	
	public ArrayList<Stmt> getStatements(){
		return this.stmts;
	}
	
	@Override
	public void accept(StmtVisitor sv) {
		sv.visit(this);
	}
	
	public String toString(){
		String block = "[";
		for(Stmt s:getStatements()){
			block += s.toString();
		}
		block += "]";
		return block;
	}
}
