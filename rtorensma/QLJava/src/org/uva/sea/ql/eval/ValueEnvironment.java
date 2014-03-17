package org.uva.sea.ql.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;

public class ValueEnvironment {
	private final Map<Ident, Value> valueEnv;
	
	public ValueEnvironment() {
		this.valueEnv = new HashMap<Ident, Value>();
	}
	
	public boolean isIdentDefined(Ident ident) {
		return this.valueEnv.containsKey(ident);
	}
	
	public Value getValueOfIdent(Ident ident) {
		if (this.isIdentDefined(ident)) {
			return this.valueEnv.get(ident);
		}
		else {
			return new Undefined();
		}
	}

	public void setValueOfIdent(Ident ident, Value value) {
		this.valueEnv.put(ident, value);
	}
}
