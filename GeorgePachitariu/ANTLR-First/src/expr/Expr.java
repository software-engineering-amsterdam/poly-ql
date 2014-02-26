package expr;

public abstract class Expr {
	protected Expr[] subExpr;
	
	public Expr(Expr subExpression) {
		this.subExpr = new Expr[1];
		this.subExpr[0] = subExpression;
	}
	
	public Expr(Expr firstSubExpression, Expr sndSubExpression) {
		this.subExpr = new Expr[2];
		this.subExpr[0] = firstSubExpression;
		this.subExpr[1] = sndSubExpression;
	}
	
	public Expr() {
		this.subExpr = null;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Expr))
			return false;
		Expr expr=(Expr) obj;
		if(this.subExpr == expr.subExpr)
			return true;
		return false;		
	}
}
