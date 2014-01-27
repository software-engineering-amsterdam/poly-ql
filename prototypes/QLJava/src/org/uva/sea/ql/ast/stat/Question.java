package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public abstract class Question extends Stat {
	private final Label label;
	private final Ident name;
	private final Type type;

	public Question(Label label, Ident name, Type type) {
		this.label = label;
		this.name = name;
		this.type = type;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public Ident getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
}
