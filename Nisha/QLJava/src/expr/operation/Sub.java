package expr.operation;

import java.util.Map;

import ast.Visitor;
import ast.type.Inttype;
import ast.type.Type;
import expr.Expr;
import expr.Ident;

public class Sub extends Operation {
	
	
	public Sub(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
	
		return new Inttype();
	}

}