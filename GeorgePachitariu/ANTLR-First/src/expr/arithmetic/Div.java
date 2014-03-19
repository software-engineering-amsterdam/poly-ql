package expr.arithmetic;


import java.util.Map;

import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;
import expr.BinaryExpr;
import expr.Expression;
import expr.Ident;
import expr.literals.Int;
import expr.literals.Literal;

public class Div extends BinaryExpr {

	public Div(Expression leftHandOperand, Expression rightHandOperand) {
		super(leftHandOperand,rightHandOperand);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		 visitor.visit(this, this.leftHandOperand, this.rightHandOperand);
	}

	@Override
	public String toString() {
		return this.leftHandOperand.toString() + "/" + this.rightHandOperand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		//the type of div is the type of its operands
		return this.leftHandOperand.getType(typeMatcher);
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=this.leftHandOperand.getType(typeMatcher);
		Type t2=this.rightHandOperand.getType(typeMatcher);
		return (t1.isCompatibleWith(t2) &&
				t1.isArithmetic());
	}
	
	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
		return this.leftHandOperand.compute(identifiers).div(
					this.rightHandOperand.compute(identifiers)
				);
	}
}
