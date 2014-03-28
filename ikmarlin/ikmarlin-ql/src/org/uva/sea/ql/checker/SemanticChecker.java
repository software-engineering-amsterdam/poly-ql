package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.exception.QLException;

public class SemanticChecker {
	
	private Form form;
	private List<QLException> errors;
	private List<QLException> warnings;
	private SymbolCollector symbolCollector;
	private Map<String, Type> symbolTable;
	
	public SemanticChecker(Form form){
		this.form = form;
		this.errors = new ArrayList<QLException>();
		this.warnings = new ArrayList<QLException>();
		this.symbolCollector = new SymbolCollector();
	}
	
	public void check(){
		if(!hasDuplicateQuestion()){
			symbolTable = symbolCollector.getSingleTypeSymbolsTable();
			checkUndefinedQuestion(symbolTable);
			checkType(symbolTable);
			checkCyclicDependency();
		}
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<QLException> getErrors(){
		return errors;
	}
	
	public boolean hasWarnings(){
		return !warnings.isEmpty();
	}
	
	public List<QLException> getWarnings(){
		return warnings;
	}
	
	public Map<String, Type> getSymbolTable(){
		return symbolTable;
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
