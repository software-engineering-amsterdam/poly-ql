package ql.ast.node.relational;

import java.util.Map;

import ql.ast.node.BinaryExpr;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.BoolType;
import ql.ast.node.types.Type;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class GEq extends BinaryExpr {

	public GEq(Expression leftHandOperand, Expression rightHandOperand) {
		super(leftHandOperand,rightHandOperand);
	}

	@Override
	public String toString() {
		return leftHandOperand.toString() + ">=" + rightHandOperand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new BoolType();
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return leftHandOperand.eval(identifiers).geq(
				rightHandOperand.eval(identifiers)
				);
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return true;
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
