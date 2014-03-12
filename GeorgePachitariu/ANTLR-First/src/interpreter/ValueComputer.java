package interpreter;

import expr.ASTNode;
import expr.Expression;

public class ValueComputer  {
	
	public boolean hasAllOperandsWithKnownValues() {
		return false;
	}
	
	public boolean computeCondition(Expression e, ASTNode root) {
		return false;
	}
	
	public int computeValue(Expression e, ASTNode root) {
		return 0;
	}
	


}
