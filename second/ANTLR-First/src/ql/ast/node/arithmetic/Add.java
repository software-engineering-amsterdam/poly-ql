package ql.ast.node.arithmetic;

import java.util.Map;

import ql.ast.node.BinaryExpr;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.IntType;
import ql.ast.node.types.Type;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Add extends BinaryExpr {	

	public Add(Expression leftHandOperand, Expression rightHandOperand) {
		super(leftHandOperand,rightHandOperand);
	}

	@Override
	public String toString() {
		return leftHandOperand.toString() + "+" + rightHandOperand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new IntType();
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return leftHandOperand.eval(identifiers).add(
				rightHandOperand.eval(identifiers)
				);
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return false;
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=leftHandOperand.getType(typeMatcher);
		Type t2=rightHandOperand.getType(typeMatcher);

		return t1.isCompatibleWith(t2) &&
				t1.isCompatibleWith(this) &&
				t2.isCompatibleWith(this);
	}
}
