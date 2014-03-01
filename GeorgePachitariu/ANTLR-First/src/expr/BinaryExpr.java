package expr;

public abstract class BinaryExpr extends Expression {
	protected Expression first;
	protected Expression second;
	
	
	public BinaryExpr(Expression first, Expression second) {
		this.first=first;
		this.second=second;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BinaryExpr))
			return false;
		BinaryExpr binaryExpr=(BinaryExpr) obj;
		return this.first.equals(binaryExpr.first) &&
				this.second.equals(binaryExpr.second);
	}	
	
	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this) || 
				this.first.containsTreeNode(e) ||
				this.second.containsTreeNode(e) )
			return true;
		return false;
	}
}
