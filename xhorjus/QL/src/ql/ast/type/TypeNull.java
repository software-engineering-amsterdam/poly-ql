package ql.ast.type;

import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;

public class TypeNull implements TypeInterface {
	public TypeNull() { }

	@Override
	public Boolean compatibleWith(StatementBoolean type) {
		return false;
	}

	@Override
	public Boolean compatibleWith(StatementMoney type) {
		return false;
	}

	@Override
	public Boolean compatibleWith(StatementString type) {
		return false;
	}
}