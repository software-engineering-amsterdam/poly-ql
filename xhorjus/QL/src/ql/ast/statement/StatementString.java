package ql.ast.statement;

import ql.ast.type.TypeInterface;
import ql.ast.type.TypeString;

/** 
 * A string statement
 */
public class StatementString implements StatementTypeInterface {
	public StatementString() { }

	@Override
	public TypeInterface getType() {
		return new TypeString();
	}
	
	@Override
	public String toStr() {
		return "string";
	}
	
}