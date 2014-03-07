package types;

import expr.Expr;

public interface Type extends Expr {
	
	public abstract boolean isCompatibleWithBoolean();
	public abstract boolean isCompatibleWithIntType();
	public abstract boolean isCompatibleWithMoney();
	public abstract boolean isCompatibleWith(Type t);
	
	public abstract boolean isBoolean();
	public abstract boolean isArithmetic();
	public abstract boolean isRelational();		
}
