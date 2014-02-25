package ql.ast.statements.types;

import ql.ast.types.TText;

public class STText implements STInterface {

	@Override
	public TText getType() {
		return new TText();
	}

	@Override
	public String toStr() {
		return "text";
	}
}
