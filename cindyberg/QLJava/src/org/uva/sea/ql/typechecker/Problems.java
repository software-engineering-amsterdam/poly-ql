package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

public class Problems {

	private List<String> warnings;
	private List<String> errors; 


	public Problems(ArrayList<String> warnings, ArrayList<String> errors) {
		this.warnings = warnings;
		this.errors = errors;
	}
	
	public void addError(String s){
		errors.add(s);
	}
	
	public void addWarnings(String s){
		warnings.add(s);
	}
	
	public void printWarnings(){
		int totalWarnings = warnings.size();
		System.out.println("WARNINGS [" + totalWarnings + "]");
		if(totalWarnings > 0){
			for(String warning : warnings){
				System.out.println(warning);
			}
		}
		
	}
	
	public void printErrors(){
		int totalErrors = errors.size();
		System.out.println("Errors [" + totalErrors + "]");
		if(totalErrors > 0){
			for(String error : errors){
				System.out.println(error);
				
			}
		}
	}

}
