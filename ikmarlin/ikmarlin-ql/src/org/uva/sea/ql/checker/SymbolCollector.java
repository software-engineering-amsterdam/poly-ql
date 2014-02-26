package org.uva.sea.ql.checker;

import java.util.HashMap;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;

public class SymbolCollector implements StmtVisitor {

	public HashMap<String, Type> symbolTable;
	
	public SymbolCollector(){
		this.symbolTable = new HashMap<String, Type>();
	}
	
	public HashMap<String, Type> populateTable(Form form){
		visit(form);
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
	public void visit(ConditionalQuestion stmt) {
		stmt.getBody().accept(this);
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s:stmt.getStatements()){
			s.accept(this);
		}
	}
	
	@Override
	public void visit(Form stmt) {
		stmt.getBlock().accept(this);
	}
	
	private void addSymbol(Question q){
		this.symbolTable.put(q.getIdent().getName(), q.getType().hasType());
	}

}
