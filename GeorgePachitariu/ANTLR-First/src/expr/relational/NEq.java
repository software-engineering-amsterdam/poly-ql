package expr.relational;

import java.util.Map;

import types.BoolType;
import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;
import expr.BinaryExpr;
import expr.Expression;
import expr.Ident;
import expr.literals.Bool;
import expr.literals.Int;
import expr.literals.Literal;

public class NEq extends BinaryExpr {

	public NEq(Expression leftHandOperand, Expression rightHandOperand) {
		super(leftHandOperand,rightHandOperand);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, this.leftHandOperand, this.rightHandOperand);
	}

	@Override
	public String toString() {
		return this.leftHandOperand.toString() + "!=" + this.rightHandOperand.toString(); 
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
				(t1.isArithmetic() || t1.isBoolean() || t1.isRelational() );
	}
	
	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
		return this.leftHandOperand.compute(identifiers).neq(
					this.rightHandOperand.compute(identifiers)
				);
	}
}
