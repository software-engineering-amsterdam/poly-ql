package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

	public abstract class BinaryOperator extends Expression {
		
		private final Expression left;
		private final Expression right;

		public BinaryOperator(Expression left, Expression right) {		
			this.left = left;
			this.right = right;
		}
		
		public Expression getLeftHand(){
			return left;
		}
		
		public Expression getRightHand(){
			return right;
		}
		
		public abstract String toString();
		
}
