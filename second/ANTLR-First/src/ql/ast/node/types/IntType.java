package ql.ast.node.types;

import ql.ast.node.arithmetic.Add;
import ql.ast.node.arithmetic.Div;
import ql.ast.node.arithmetic.Mul;
import ql.ast.node.arithmetic.Sub;
import ql.ast.node.relational.Eq;
import ql.ast.node.relational.GEq;
import ql.ast.node.relational.GT;
import ql.ast.node.relational.LEq;
import ql.ast.node.relational.LT;
import ql.ast.node.relational.NEq;
import ql.ast.node.sign.Neg;
import ql.ast.node.sign.Pos;
import ql.ast.visitor.ASTVisitor;


public class IntType extends Type {

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "integer";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return false;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return true;
	}

	@Override
	public boolean isCompatibleWithString() {
		return false;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithInt();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IntType))
			return false;
		return true;
	}

	@Override
	public boolean isCompatibleWith(Add add) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Div div) {
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Mul mul) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Sub sub) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Eq eq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(GEq gEq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(GT gt) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(LEq lEq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(LT lt) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(NEq nEq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Neg neg) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Pos pos) { 
		return true; 
	}
}
