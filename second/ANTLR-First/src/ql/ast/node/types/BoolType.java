package ql.ast.node.types;

import ql.ast.node.conditional.And;
import ql.ast.node.conditional.Or;
import ql.ast.node.relational.Eq;
import ql.ast.node.relational.NEq;
import ql.ast.node.sign.Not;
import ql.ast.visitor.ASTVisitor;

public class BoolType extends Type {

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return true;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return false;
	}

	@Override
	public boolean isCompatibleWithString() {
		return false;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBoolean();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BoolType))
			return false;
		return true;
	}

	@Override
	public boolean isCompatibleWith(And and) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Or or) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Eq eq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(NEq nEq) { 
		return true; 
	}

	@Override
	public boolean isCompatibleWith(Not not) { 
		return true; 
	}

	@Override
	public boolean isBool() { 
		return true;	
	}
}
