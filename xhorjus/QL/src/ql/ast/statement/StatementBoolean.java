package ql.ast.statement;

import ql.ast.type.TypeBool;
import ql.ast.type.TypeInterface;

/** 
 * A boolean statement
 */
public class StatementBoolean implements StatementTypeInterface {
	public StatementBoolean() { }

	@Override
	public TypeInterface getType() {
		return new TypeBool();
	}
	
	@Override
	public String toStr() {
		return "boolean";
	}
	
}