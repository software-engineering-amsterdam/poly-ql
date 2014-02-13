package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

	public abstract class BinaryOperator extends Expression {
		
		Expression left;
		Expression right;

		public BinaryOperator(Expression left, Expression right) {
			
			this.left = left;
			this.right = right;
		}
		
		public Expression returnLeft(){
			return left;
		}
		
		public Expression returnRight(){
			return right;
		}
		
		
		

}
