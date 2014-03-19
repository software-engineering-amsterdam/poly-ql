package ql.ast.value;

public class Bool extends Value {
	private final boolean value;
	
	public Bool(boolean value){
		this.value = value;
	}
	
	public Bool(){
		this.value = false;
	}
	
	public boolean getValue(){
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		if (obj == this)
			return true;
		else
			return ((Bool)obj).getValue() == this.getValue();
	}

}
