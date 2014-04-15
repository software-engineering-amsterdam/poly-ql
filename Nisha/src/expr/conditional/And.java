package expr.conditional;

import java.util.Map;

import ast.Visitor;
import ast.type.Booltype;
import ast.type.Type;
import expr.Expr;
import expr.Ident;
import expr.operation.Operation;

public 	class And extends Operation{


	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);

	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return 	visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		return new Booltype();
	}


}