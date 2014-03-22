package ast.types;

import ast.ASTNode;

public abstract class Type implements ASTNode{
	
	public abstract boolean isCompatibleTo(Type type); 	

	public boolean isCompatibleToBool(){
		return false;
	}
	
	public boolean isCompatibleToInt(){
		return false;
	}
	
	public boolean isCompatibleToStr(){
		return false;
	}
	
}
