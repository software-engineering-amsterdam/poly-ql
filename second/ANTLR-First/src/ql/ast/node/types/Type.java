package ql.ast.node.types;

import ql.ast.node.ASTNode;
import ql.ast.node.arithmetic.Add;
import ql.ast.node.arithmetic.Div;
import ql.ast.node.arithmetic.Mul;
import ql.ast.node.arithmetic.Sub;
import ql.ast.node.conditional.And;
import ql.ast.node.conditional.Or;
import ql.ast.node.relational.Eq;
import ql.ast.node.relational.GEq;
import ql.ast.node.relational.GT;
import ql.ast.node.relational.LEq;
import ql.ast.node.relational.LT;
import ql.ast.node.relational.NEq;
import ql.ast.node.sign.Neg;
import ql.ast.node.sign.Not;
import ql.ast.node.sign.Pos;

public abstract class Type implements ASTNode {

	public abstract boolean isCompatibleWithBoolean();
	public abstract boolean isCompatibleWithInt();
	public abstract boolean isCompatibleWith(Type t);
	public abstract boolean isCompatibleWithString();

	public boolean isCompatibleWith(Add add) { return false; }
	public boolean isCompatibleWith(Div div) { return false; }
	public boolean isCompatibleWith(Mul mul) { return false; }
	public boolean isCompatibleWith(Sub sub) { return false; }
	public boolean isCompatibleWith(And and) { return false; }
	public boolean isCompatibleWith(Or or) 	 { return false; }
	public boolean isCompatibleWith(Eq eq)   { return false; }
	public boolean isCompatibleWith(GEq gEq) { return false; }
	public boolean isCompatibleWith(GT gt)   { return false; }
	public boolean isCompatibleWith(LEq lEq) { return false; }
	public boolean isCompatibleWith(LT lt)   { return false; }
	public boolean isCompatibleWith(NEq nEq) { return false; }
	public boolean isCompatibleWith(Neg neg) { return false; }
	public boolean isCompatibleWith(Not not) { return false; }
	public boolean isCompatibleWith(Pos pos) { return false; }

	public boolean isBool() { return false;	}
}
