package nodeAST.relational;

import java.util.Map;

import nodeAST.BinaryExpr;
import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.literals.Bool;
import nodeAST.literals.Int;
import nodeAST.literals.Literal;


import types.BoolType;
import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;

public class Eq extends BinaryExpr {

	public Eq(Expression leftHandOperand, Expression rightHandOperand) {
		super(leftHandOperand,rightHandOperand);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, this.leftHandOperand, this.rightHandOperand);
	}

	@Override
	public String toString() {
		return this.leftHandOperand.toString() + "==" + this.rightHandOperand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new BoolType();
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=this.leftHandOperand.getType(typeMatcher);
		Type t2=this.rightHandOperand.getType(typeMatcher);
		return t1.isCompatibleWith(t2) &&
				(t1.isArithmetic() || t1.isBoolean() || t1.isRelational() || t1.isString()  );
	}
	
	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
		return this.leftHandOperand.compute(identifiers).eq(
					this.rightHandOperand.compute(identifiers)
				);
	}
}
