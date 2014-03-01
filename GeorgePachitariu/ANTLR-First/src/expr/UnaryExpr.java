package expr;


public abstract class UnaryExpr extends Expression {
	protected Expression first;
	
	public UnaryExpr(Expression fst) {
		this.first=fst;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UnaryExpr))
			return false;
		UnaryExpr unaryExpr=(UnaryExpr) obj;
		return this.first.equals(unaryExpr.first);
	}
	
	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this) || this.first.containsTreeNode(e) )
			return true;
		return false;
	}
}
