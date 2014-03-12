package problems;

public abstract class Warning {

	String description;
	
	Warning(String description){
		this.description = description;
	}
	
	public String getString(){
		return description;
	}
}
