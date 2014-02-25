package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Error;
import org.uva.sea.ql.ast.type.Type;


public class StmtChecker implements StmtVisitor {
	
	private HashMap<String, Type> symbolTable;
	private ExprChecker ec;
	private ArrayList<Error> errors;
	
	public StmtChecker(HashMap<String, Type> symbolTable) {
		this.setSymbolTable(symbolTable);
		this.setExprChecker(new ExprChecker(symbolTable));
		this.setErrors(new ArrayList<Error>());
	}

	public HashMap<String, Type> getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(HashMap<String, Type> symbolTable) {
		this.symbolTable = symbolTable;
	}

	public ExprChecker getExprChecker() {
		return ec;
	}

	public void setExprChecker(ExprChecker ec) {
		this.ec = ec;
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public ArrayList<Error> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<Error> errors) {
		this.errors = errors;
	}
	
	private void addExprErrors(List<Error> all){
		errors.addAll(all);
		ec.resetErrors();
	}
	
	private void addError(String msg){
		errors.add(new Error(msg));
	}
	
	public void typeCheck(Form form){
		visit(form);
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		Type computationType = ec.infer(stmt.getComputation());
		Type questionType = stmt.getType().hasType();
		addExprErrors(ec.getErrors());
		if(!computationType.isCompatibleWith(questionType)){
			String error = "the expression << "+stmt.getComputation()+" >> is not compatible with the type "+questionType+".";
			addError(error);
		}
	}

	@Override
	public void visit(ConditionalQuestion stmt) {
		Type conditionType = ec.infer(stmt.getCondition());
		addExprErrors(ec.getErrors());
		if(!conditionType.isCompatibleWithBool()){
			String error = "the condition << "+stmt.getCondition()+" >> is not a boolean.";
			addError(error);
		}
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

}
