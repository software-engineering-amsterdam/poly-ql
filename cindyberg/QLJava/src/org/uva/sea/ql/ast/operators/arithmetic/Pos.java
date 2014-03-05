package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Pos extends UnaryOperator {

	public Pos(Expression expr) {
		
		super(expr);
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}

	@Override
	public String toString() {
		return "";
	}

	public Type typeOf(TypeEnvironment environment) {
		return new IntegerType();		
	}
	
	

}
