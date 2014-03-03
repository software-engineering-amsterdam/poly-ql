package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;

public class SymbolCollectorStmtVisitor implements IStmtVisitor {

	private Map<String, List<Type>> symbolTable;
	
	public SymbolCollectorStmtVisitor(){
		this.symbolTable = new HashMap<String, List<Type>>();
	}
	
	public Map<String, List<Type>> getSymbolTable(){
		return this.symbolTable;
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
		addSymbol(stmt);
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		addSymbol(stmt);
	}

	@Override
	public void visit(IfThenStatement stmt) {
		stmt.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		stmt.getBody().accept(this);
		stmt.getElseBlock().accept(this);
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s:stmt.getStatements()){
			s.accept(this);
		}
	}
	
	private void addSymbol(Question q){
		String ident = q.getIdent().getName();
		List<Type> types;
		if(symbolTable.containsKey(ident)){
			types = symbolTable.get(ident);
		}else{
			types = new ArrayList<Type>();
		}
		types.add(q.getType());
		symbolTable.put(ident, types);
	}

}
