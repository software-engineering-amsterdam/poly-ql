package problems;


public abstract class Error{

	private String description;
	
	Error(String description){
		this.description = description;
	}
	
	public String toString(){
		return description;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Error) {
	        return description.equals(((Error) other).description);
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
}
