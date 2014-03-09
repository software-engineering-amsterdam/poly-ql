package types;

import expr.ASTNode;

public interface Type extends ASTNode {

	public abstract boolean isCompatibleWithBoolean();
	public abstract boolean isCompatibleWithInt();
	public abstract boolean isCompatibleWithMoney();
	public abstract boolean isCompatibleWith(Type t);
	
	public abstract boolean isBoolean();
	public abstract boolean isArithmetic();
	public abstract boolean isRelational();		
}
