package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Computed extends Question {
	private final Expr expr;

	public Computed(Label label, Ident name, Type type, Expr expr) {
		super(label, name, type);
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
