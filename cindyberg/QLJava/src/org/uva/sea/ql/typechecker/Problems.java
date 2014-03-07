package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

public class Problems {

	private List<String> warnings;
	private List<String> errors; 


	public Problems() {
		warnings = new ArrayList<String>();
		errors = new ArrayList<String>();
	}
	
	public void addError(String s){
		errors.add(s);
	}
	
	public void addWarning(String s){
		warnings.add(s);
	}
	
	public void printWarnings(){
		print(warnings, "WARNINGS");
	}
	
	public void printErrors(){
		print(errors,"ERRORS");
	}
	
	public List<String> getProblems(){
		List<String> allProblems = new ArrayList<String>();
		for(String s : warnings){
			allProblems.add(s);
		}
		for(String s: errors){
			allProblems.add(s);
		}
		return allProblems;
	}
	
	public Boolean hasProblems(){
		return (warnings.size() == 0 && errors.size() == 0);
	}
	
	private void print(List<String> problems, String label){
		int totalErrors = problems.size();
		System.out.println(label +" [" + totalErrors + "]");
		for(String problem : problems){
			System.out.println(problem);
		}
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	public List<String> getWarnings(){
		return warnings;
	}
}
