package expr.literals;

import expr.Expression;
import typeChecker.ASTVisitor;
import types.BoolType;
import types.IntType;
import types.Type;


public class Int extends Expression {
	private int value;

	public Int(int value) {
		super();
		this.value=value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Int))
			return false;
		Int expr=(Int) obj;
		return expr.value == this.value;
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "int";
	}
	
	@Override
	public Type getType() {
		return new IntType();
	}
	
	@Override
	public boolean areOperandsTypeValid() {
		return true;
	}
	
	@Override
	public boolean containsTreeNode(Expression e) {
		if(e.equals(this))
			return true;
		return false;
	}

}
