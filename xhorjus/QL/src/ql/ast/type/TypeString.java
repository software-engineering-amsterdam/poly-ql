package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

/** 
 * "string" token class
 */
public class TypeString implements TypeInterface {
	public TypeString() { }

	@Override
	public Boolean compatibleWith(StatementBoolean type) {
		return false;
	}

	@Override
	public Boolean compatibleWith(StatementMoney type) {
		return true;
	}

	@Override
	public Boolean compatibleWith(StatementString type) {
		return true;
	}

	@Override
	public String toStr() {
		return "string";
	}
}