package ql.ast.value;

public class Int extends Value{
	private final Integer value;
	
	public Int(Integer value){
		this.value = value;
	}
	
	public Int(){
		this.value = 0;
	}
	
	public Integer getValue(){
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		if (obj == this)
			return true;
		else
			return ((Int)obj).getValue().equals(this.getValue());
	}	
}
