package typecheck;

import java.util.ArrayList;

public class ErrorList {
	
	private ArrayList<String> errorList = new ArrayList<String>();
	private ArrayList<String> warningList = new ArrayList<String>();

	public void addError(String error) {
		errorList.add(error);
	}

	public void addWarning(String warning) {
		warningList.add(warning);
	}

	public String toString(){
		String errors = "";
		for(String s: errorList){
			errors += s + "\n";
		}
		for(String s: warningList){
			errors += s + "\n";
		}
		return errors.toString();
	}

}
