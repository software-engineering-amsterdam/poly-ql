package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.error.IllegalBooleanError;
import org.uva.sea.ql.checker.error.IncompatibleTypesError;

public class TypeStmtVisitor implements IStmtVisitor {
	
	TypeExprVisitor ev;
	List<String> errors;
	
	public TypeStmtVisitor(Map<String, Type> symbolTable){
		this.ev = new TypeExprVisitor(symbolTable);
		this.errors = new ArrayList<String>();
	}
	
	private void addExprErrors(TypeExprVisitor ev){
		errors.addAll(ev.getErrors());
		ev.resetErrors();
	}
	
	private void addError(String msg){
		errors.add(msg);
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<String> getErrors(){
		return errors;
	}

	private void checkCondition(ConditionalQuestion stmt){
		Type condition = stmt.getCondition().accept(ev);
		addExprErrors(ev);
		if(!condition.isCompatibleWithBool()){
			addError(IllegalBooleanError.getMessage(stmt.getCondition(), condition));
		}
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		Type computation = stmt.getComputation().accept(ev);
		addExprErrors(ev);
		if(!computation.isCompatibleWith(stmt.getType())){
			addError(IncompatibleTypesError.getMessage(stmt.getIdent(), stmt.getType(), stmt.getComputation(), computation));
		}
	}

	@Override
	public void visit(IfThenStatement stmt) {
		checkCondition(stmt);
		stmt.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		checkCondition(stmt);
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
