package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Stat {
	private final Ident name;
	private final String label;
	private final Type type;

	public Question(Ident name, String label, Type type) {
		this.name = name;
		this.label = label;
		this.type = type;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Ident getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
}
