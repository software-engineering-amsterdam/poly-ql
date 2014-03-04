package ast.expr.types;

import ast.ASTNode;

public abstract class Type implements ASTNode{
	
	private boolean unknown = true;
	
	public abstract boolean isCompatibleTo(Type type); 	
	public abstract String show();

	public boolean isCompatibleToBool(){
		return false;
	}
	
	public boolean isCompatibleToInt(){
		return false;
	}
	
	public boolean isCompatibleToMoney() {
		return false;
	}
	
	public boolean isCompatibleToStr(){
		return false;
	}
	
	public void setKnown(){
		this.unknown = false;
	}
	
	public boolean isUnknown(){
		return unknown;
	}

}
