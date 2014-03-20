package problems;
public abstract class Warning {

	private final String description;
	
	Warning(String description){
		this.description = description;
	}
	
	public String toString(){
		return description;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Warning) {
	        return description.equals(((Warning) other).description);
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
}
