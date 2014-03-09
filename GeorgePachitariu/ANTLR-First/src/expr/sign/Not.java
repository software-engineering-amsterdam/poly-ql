package expr.sign;

import typeChecker.ASTVisitor;
import typeChecker.IdentifiersTypeMatcher;
import types.Type;
import expr.Expression;
import expr.UnaryExpr;

public class Not extends UnaryExpr {

	public Not(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.operand.accept(visitor);
	}

	@Override
	public String toString() {
		return "!" + this.operand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		return this.operand.getType(typeMatcher);
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=this.operand.getType(typeMatcher);
		return t1.isBoolean();
	}
}
