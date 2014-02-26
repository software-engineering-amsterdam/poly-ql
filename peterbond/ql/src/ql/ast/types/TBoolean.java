package ql.ast.types;

import ql.ast.statements.types.STBoolean;
import ql.ast.statements.types.STText;
import ql.ast.statements.types.STMoney;

public class TBoolean implements TInterface {
	
	@Override
	public String toStr() {
		return "boolean";
	}

	@Override
	public Boolean isCompatible(STBoolean statementType) {
		return true;
	}

	@Override
	public Boolean isCompatible(STText statementType) {
		return false;
	}

	@Override
	public Boolean isCompatible(STMoney statementType) {
		return false;
	}

}
