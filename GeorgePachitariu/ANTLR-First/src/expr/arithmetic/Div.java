package expr.arithmetic;


import typeChecker.ASTVisitor;
import typeChecker.IdentifiersTypeMatcher;
import types.Type;
import expr.BinaryExpr;
import expr.Expression;

public class Div extends BinaryExpr {

	public Div(Expression first, Expression second) {
		super(first,second);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.leftHandOperand.accept(visitor);
		this.rightHandOperand.accept(visitor);
	}

	@Override
	public String toString() {
		return this.leftHandOperand.toString() + "/" + this.rightHandOperand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return this.leftHandOperand.getType(typeMatcher);
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=this.leftHandOperand.getType(typeMatcher);
		Type t2=this.rightHandOperand.getType(typeMatcher);
		return (t1.isCompatibleWith(t2) &&
				t1.isArithmetic());
	}
}
