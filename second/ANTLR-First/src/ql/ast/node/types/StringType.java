package ql.ast.node.types;

import ql.ast.node.relational.Eq;
import ql.ast.node.relational.NEq;
import ql.ast.visitor.ASTVisitor;

public class StringType  extends Type {
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "int";
	}

	@Override
	public boolean isCompatibleWithBoolean() {
		return false;
	}

	@Override
	public boolean isCompatibleWithInt() {
		return false;
	}

	@Override
	public boolean isCompatibleWithString() {
		return true;
	}

	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IntType))
			return false;
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

}
