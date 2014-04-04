package ql.ast.node;


public abstract class UnaryExpr extends Expression {
	protected Expression operand;

	public UnaryExpr(Expression fst) {
		this.operand=fst;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UnaryExpr))
			return false;
		obj.getClass().equals(this.getClass());
		UnaryExpr unaryExpr=(UnaryExpr) obj;
		return operand.equals(unaryExpr.operand);
	}

	@Override
	public boolean contains(Ident i) {
		if(i.equals(this) || operand.contains(i))
			return true;
		return false;
	}
}
