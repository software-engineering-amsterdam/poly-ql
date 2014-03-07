package org.uva.sea.ql.ast.stmt;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.checker.visitor.IStmtVisitor;

public class Block extends Stmt {
	
	private List<Stmt> stmts;
	
	public Block(){
		this.stmts = new ArrayList<Stmt>();
	}
	
	public void addStmt(Stmt stmt){
		this.stmts.add(stmt);
	}
	
	public List<Stmt> getStatements(){
		return this.stmts;
	}
	
	@Override
	public void accept(IStmtVisitor sv) {
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
