package ast.type;

import ast.ASTNode;

public abstract class Type implements ASTNode {
	
	public abstract boolean istype(Type type);
		
	
	public boolean isBool() {
		return false;
	}

	public boolean isStr() {
		return false;
	}

	public boolean isInt() {
		return false;
	}
}
