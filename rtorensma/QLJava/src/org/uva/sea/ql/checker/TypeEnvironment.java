package org.uva.sea.ql.checker;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public class TypeEnvironment {
	
	private final Map<Ident, Type> typeEnv;
	
	public TypeEnvironment() {
		this.typeEnv = new HashMap<Ident, Type>();
	}
	
	public boolean isIdentDefined(Ident ident) {
		return this.typeEnv.containsKey(ident);
	}
	
	public Type getTypeOfIdent(Ident ident) {
		if (this.isIdentDefined(ident)) {
			return this.typeEnv.get(ident);
		}
		else {
			return new org.uva.sea.ql.ast.types.Undefined();
		}
	}
	
	public void setTypeOfIdent(Ident ident, Type type) {
		this.typeEnv.put(ident, type);
	}
}
