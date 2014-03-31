package typecheck;

import java.util.ArrayList;

public class ErrorList {
	
	private ArrayList<String> errorList = new ArrayList<String>();

	public void addError(String error) {
		errorList.add(error);
	}
	
	public String toString(){
		String errors = "";
		for(String s: errorList){
			errors += s + "\n";
		}
		return errors.toString();
	}

}
