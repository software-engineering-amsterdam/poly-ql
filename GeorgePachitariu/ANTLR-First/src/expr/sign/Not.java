package expr.sign;

import java.util.Map;

import types.Type;
import visitor.ASTVisitor;
import visitor.IdentifiersTypeMatcher;
import expr.Expression;
import expr.Ident;
import expr.UnaryExpr;
import expr.literals.Bool;
import expr.literals.Int;
import expr.literals.Literal;

public class Not extends UnaryExpr {

	public Not(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this, this.operand);
	}

	@Override
	public String toString() {
		return "!" + this.operand.toString(); 
	}

	@Override
	public Type getType(IdentifiersTypeMatcher typeMatcher) {
		//the type of not is the type of its operands
		return this.operand.getType(typeMatcher);
	}

	@Override
	public boolean areOperandsTypeValid(IdentifiersTypeMatcher typeMatcher) {
		Type t1=this.operand.getType(typeMatcher);
		return t1.isBoolean();
	}
	
	@Override
	public Literal compute(Map<Ident, Expression> identifiers) {
		return this.operand.compute(identifiers).not();
	}
}
