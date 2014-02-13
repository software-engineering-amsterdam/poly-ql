package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;

public class Pos extends UnaryOperator {

	public Pos(Expression expr) {
		
		super(expr);
	}

	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public String show() {
		return "";
	}
	
	

}
