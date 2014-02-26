package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

/** 
 * "money" token class
 */
public class TypeMoney implements TypeInterface {
	public TypeMoney() { }

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
		return false;
	}

	@Override
	public String toStr() {
		return "money";
	}
}