package ast.types;

import ast.ASTNode;
import ast.visitors.TypeVisitor;

public abstract class Type extends ASTNode{
	
	public abstract <T> T accept(TypeVisitor<T> visitor);
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
