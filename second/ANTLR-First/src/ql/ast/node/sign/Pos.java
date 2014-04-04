package ql.ast.node.sign;

import java.util.Map;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.UnaryExpr;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.IntType;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Pos extends UnaryExpr {

	public Pos(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, operand);
	}

	@Override
	public String toString() {
		return "+" + operand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new IntType();
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=operand.getType(typeMatcher);
		return t1.isCompatibleWith(this);
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return operand.eval(identifiers).pos();
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return false;
	}
}
