package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.error.UndefinedVariable;

public class UndefinedVariableStmtVisitor implements IStmtVisitor {
	
	private UndefinedVariableExprVisitor ev;
	private List<String> errors;
	private Map<String, Type> symbolTable;
	List<Ident> variables;
	
	public UndefinedVariableStmtVisitor(Map<String, Type> symbolTable){
		this.ev = new UndefinedVariableExprVisitor();
		this.errors = new ArrayList<String>();
		this.symbolTable = symbolTable;
		this.variables = new ArrayList<Ident>();
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	private void checkExpr(Expr ex){
		ev.resetVariables();
		List<Ident> variables = ex.accept(ev);
		for(Ident ident : variables){
			if(!symbolTable.containsKey(ident.getName())){
				errors.add(UndefinedVariable.getMessage(ident));
			}
		}
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		checkExpr(stmt.getComputation());
	}

	@Override
	public void visit(IfThenStatement stmt) {
		checkExpr(stmt.getCondition());
		stmt.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		checkExpr(stmt.getCondition());
		stmt.getBody().accept(this);
		stmt.getElseBlock().accept(this);
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s : stmt.getStatements()){
			s.accept(this);
		}
	}
	
}