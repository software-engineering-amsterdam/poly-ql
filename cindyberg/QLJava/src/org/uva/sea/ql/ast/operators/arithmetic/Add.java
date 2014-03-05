package org.uva.sea.ql.ast.operators.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;


public class Add extends BinaryOperator {

	
	public Add(Expression left, Expression right){
		
		super(left,right);
	}

	
	public String toString(){
		return "+";
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}


	public Type typeOf(TypeEnvironment environment) {
		return new IntegerType();
	}

}
