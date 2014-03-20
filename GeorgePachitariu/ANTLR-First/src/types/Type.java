package types;

import nodeAST.ASTNode;

public interface Type extends ASTNode {

	public boolean isCompatibleWithBoolean();
	public boolean isCompatibleWithInt();
	public boolean isCompatibleWithMoney();
	public boolean isCompatibleWith(Type t);
	public boolean isCompatibleWithString();	

	public boolean isBoolean();
	public boolean isArithmetic();
	public boolean isRelational();
	public boolean isString();

}
