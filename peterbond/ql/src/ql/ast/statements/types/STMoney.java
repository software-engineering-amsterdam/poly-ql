package ql.ast.statements.types;

import ql.ast.types.TMoney;

public class STMoney implements STInterface {

	@Override
	public TMoney getType() {
		return new TMoney();
	}

	@Override
	public String toStr() {
		return "money";
	}

}