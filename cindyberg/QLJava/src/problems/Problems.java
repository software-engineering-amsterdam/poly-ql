package problems;

import java.util.ArrayList;
import java.util.Iterator;

public class Problems{
	
	//Public because they need to be Iterable
	public Iterable<Warning> warnings;
	public Iterable<Error> errors; 

	public Problems() {
		warnings = new ArrayList<Warning>();
		errors = new ArrayList<Error>();
	}
	
	public void addError(Error e){
		((ArrayList<Error>) errors).add(e);
	}
	
	public void addWarning(Warning w){
		((ArrayList<Warning>) warnings).add(w);
	}
	
	public Boolean hasProblems(){
		return (((ArrayList<Warning>) warnings).size() == 0 && ((ArrayList<Error>) errors).size() == 0);
	}

	public Iterator<Error> errorIterator() {
		return errors.iterator();
	}
	
	public Iterator<Warning> warningIterator(){
		return warnings.iterator();
	}
}
