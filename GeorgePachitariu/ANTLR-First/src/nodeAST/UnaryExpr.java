package nodeAST;


public abstract class UnaryExpr extends Expression {
	protected Expression operand;

	public UnaryExpr(Expression fst) {
		this.operand=fst;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UnaryExpr))
			return false;
		UnaryExpr unaryExpr=(UnaryExpr) obj;
		return this.operand.equals(unaryExpr.operand);
	}

	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this) || this.operand.containsTreeNode(e) )
			return true;
		return false;
	}
}
