package ast.expr.types;

import ast.ASTNode;

public abstract class Types implements ASTNode{
	
	private boolean unknown = true;
	
	public abstract boolean isCompatableTo(Types type); 	

	public boolean isCompatableToBool(){
		return false;
	}
	
	public boolean isCompatableToInt(){
		return false;
	}
	
	public boolean isCompatableToMoney() {
		return false;
	}
	
	public boolean isCompatableToStr(){
		return false;
	}
	
	public void setKnown(){
		this.unknown = false;
	}
	
	public boolean isUnknown(){
		return unknown;
	}

}
