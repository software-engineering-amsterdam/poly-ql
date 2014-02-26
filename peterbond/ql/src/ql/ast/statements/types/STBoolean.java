package ql.ast.statements.types;

import ql.ast.types.TBoolean;

public class STBoolean implements STInterface {
	@Override
	public TBoolean getType() {
		return new TBoolean();
	}

	@Override
	public String toStr() {
		return "boolean";
	}
}
