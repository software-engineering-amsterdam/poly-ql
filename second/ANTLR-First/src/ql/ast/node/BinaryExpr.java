package ql.ast.node;

import ql.ast.visitor.ASTVisitor;

public abstract class BinaryExpr extends Expression {
	protected Expression leftHandOperand;
	protected Expression rightHandOperand;

	public BinaryExpr(Expression leftHandOperand, Expression rightHandOperand) {
		this.leftHandOperand=leftHandOperand;
		this.rightHandOperand=rightHandOperand;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BinaryExpr))
			return false;
		obj.getClass().equals(this.getClass());
		BinaryExpr binaryExpr=(BinaryExpr) obj;
		return leftHandOperand.equals(binaryExpr.leftHandOperand) &&
				rightHandOperand.equals(binaryExpr.rightHandOperand);
	}	

	@Override
	public boolean contains(Ident i) {
		if(i.equals(this) || 
				leftHandOperand.contains(i) ||
				rightHandOperand.contains(i) )
			return true;
		return false;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(leftHandOperand, rightHandOperand);
	}


}
