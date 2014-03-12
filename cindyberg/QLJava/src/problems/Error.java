package problems;


public abstract class Error{

	String description;
	
	Error(String description){
		this.description = description;
	}
	
	public String getString(){
		return description;
	}
}
