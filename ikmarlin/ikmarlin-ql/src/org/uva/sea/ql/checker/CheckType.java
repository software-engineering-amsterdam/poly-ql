package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.exception.error.Error;
import org.uva.sea.ql.checker.exception.error.IllegalBooleanError;
import org.uva.sea.ql.checker.exception.error.IncompatibleTypesError;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;
import org.uva.sea.ql.checker.visitor.ExprVisitorType;

public class CheckType implements IStmtVisitor {
	
	private List<Error> errors;
	private Map<String, Type> symbolTable;
	
	public CheckType(Form form, Map<String, Type> symbolTable){
		this.errors = new ArrayList<Error>();
		this.symbolTable = symbolTable;
		form.getBlock().accept(this);
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<Error> getErrors(){
		return errors;
	}
	
	private void checkCondition(ConditionalQuestion stmt){
		ExprVisitorType ev = new ExprVisitorType(symbolTable);
		Type condition = stmt.getCondition().accept(ev);
		errors.addAll(ev.getErrors());
		if(!condition.isCompatibleWithBool()){
			errors.add(new IllegalBooleanError(stmt.getCondition(), condition));
		}
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		ExprVisitorType ev = new ExprVisitorType(symbolTable);
		Type computation = stmt.getComputation().accept(ev);
		errors.addAll(ev.getErrors());
		if(!computation.isCompatibleWith(stmt.getType())){
			errors.add(new IncompatibleTypesError(stmt.getIdent(), stmt.getType(), stmt.getComputation(), computation));
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
