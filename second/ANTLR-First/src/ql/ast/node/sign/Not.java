package ql.ast.node.sign;

import java.util.Map;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.UnaryExpr;
import ql.ast.node.literals.Literal;
import ql.ast.node.types.BoolType;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;
import ql.ast.visitor.IdentifiersTypeMatcher;

public class Not extends UnaryExpr {

	public Not(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, operand);
	}

	@Override
	public String toString() {
		return "!" + operand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return new BoolType();
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=operand.getType(typeMatcher);
		return t1.isCompatibleWith(this);
	}

	@Override
	public Literal eval(Map<Ident, Literal> identifiers) {
		return this.operand.eval(identifiers).not();
	}

	@Override
	public boolean isBoolean(IdentifiersTypeMatcher typeMatcher) {
		return true;
	}


}
