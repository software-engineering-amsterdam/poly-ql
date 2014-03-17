package problems;

import java.util.ArrayList;
import java.util.List;

public class Problems{
	
	private List<Warning> warnings;
	private List<Error> errors; 


	public Problems() {
		warnings = new ArrayList<Warning>();
		errors = new ArrayList<Error>();
	}
	
	public void addError(Error e){
		errors.add(e);
	}
	
	public void addWarning(Warning w){
		warnings.add(w);
	}
	
	public Boolean hasProblems(){
		return (warnings.size() == 0 && errors.size() == 0);
	}
	
/*	private void print(List<String> problems, String label){
		int totalErrors = problems.size();
		System.out.println(label +" [" + totalErrors + "]");
		for(String problem : problems){
			System.out.println(problem);
		}
	}
	*/
	public List<Error> getErrors(){
		return errors;
	}
	
	public List<Warning> getWarnings(){
		return warnings;
	}

}
