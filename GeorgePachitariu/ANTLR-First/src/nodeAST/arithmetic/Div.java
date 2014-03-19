package nodeAST.arithmetic;


import java.util.Map;

import nodeAST.BinaryExpr;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.literals.Int;
import nodeAST.literals.Literal;


import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;

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
