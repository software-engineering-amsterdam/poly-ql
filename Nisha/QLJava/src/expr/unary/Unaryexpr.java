package expr.unary;

import expr.Expr;

public abstract class Unaryexpr extends Expr {

	private Expr operand;
	public Unaryexpr(Expr operand) {
		
		this.setOperand(operand);
	}
	public Expr getOperand() {
		return operand;
	}
	public void setOperand(Expr operand) {
		this.operand = operand;
	}

}
