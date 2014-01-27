package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Answerable extends Question {
	public Answerable(Label label, Ident name, Type type) {
		super(label, name, type);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	
}
