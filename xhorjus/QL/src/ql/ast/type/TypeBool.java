package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

/** 
 * "boolean" token class
 */
public class TypeBool implements TypeInterface {
	public TypeBool() { }

	@Override
	public Boolean compatibleWith(StatementBoolean type) {
		return true;
	}

	@Override
	public Boolean compatibleWith(StatementMoney type) {
		return false;
	}

	@Override
	public Boolean compatibleWith(StatementString type) {
		return false;
	}

	@Override
	public String toStr() {
		return "boolean";
	}

}