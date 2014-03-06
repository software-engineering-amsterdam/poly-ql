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
	
	private void print(List<String> problems, String label){
		int totalErrors = problems.size();
		System.out.println(label +" [" + totalErrors + "]");
		for(String problem : problems){
			System.out.println(problem);

		}
	
	}
}
