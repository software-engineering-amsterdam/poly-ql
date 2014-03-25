package ql.ast.value;

public class Str extends Value{
	
private final String value;
	
	public Str(String value){
		this.value = value;
	}
	
	public Str(){
		this.value = "";
	}
	
	public String getValue(){
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		else if (obj == this)
			return true;
		else
			return ((Str)obj).getValue().equals(this.getValue());
	}
}
