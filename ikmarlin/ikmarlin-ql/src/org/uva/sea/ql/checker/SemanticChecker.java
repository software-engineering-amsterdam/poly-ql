package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.error.Error;
import org.uva.sea.ql.checker.warning.Warning;

public class SemanticChecker {
	
	private Form form;
	private List<Error> errors;
	private List<Warning> warnings;
	private SymbolCollector symbolCollector;
	
	public SemanticChecker(Form form){
		this.form = form;
		this.errors = new ArrayList<Error>();
		this.warnings = new ArrayList<Warning>();
		this.symbolCollector = new SymbolCollector();
	}
	
	public boolean hasSemanticErrors(){
		if(!hasDuplicateQuestion()){
			Map<String, Type> symbolTable = symbolCollector.getSingleTypeSymbolsTable();
			checkUndefinedQuestion(symbolTable);
			checkType(symbolTable);
			checkCyclicDependency();
		}
		return !errors.isEmpty();
	}
	
	public List<Error> getErrors(){
		return errors;
	}
	
	public List<Warning> getWarnings(){
		return warnings;
	}
	
	private boolean hasDuplicateQuestion() {
		Map<String, List<Type>> duplicatesSymbolTable = symbolCollector.getSymbolTable(form);
		CheckDuplicateQuestion cdq = new CheckDuplicateQuestion(duplicatesSymbolTable);
		errors.addAll(cdq.getDuplicates());
		warnings.addAll(cdq.getWarnings());
		return cdq.hasErrors();
	}

	private void checkUndefinedQuestion(Map<String, Type> symbolTable) {
		CheckUndefinedQuestion cuq = new CheckUndefinedQuestion(form,symbolTable);
		errors.addAll(cuq.getErrors());
	}

	private void checkType(Map<String, Type> symbolTable) {
		CheckType ce = new CheckType(form, symbolTable);
		errors.addAll(ce.getErrors());
	}

	private void checkCyclicDependency() {
		CheckCyclicDependency ccd = new CheckCyclicDependency(form);
		errors.addAll(ccd.getCyclicDependencies());
	}

}
