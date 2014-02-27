package ast.visitors;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.IdentLiteral;
import ast.expr.binExpr.*;
import ast.expr.evaluate.Value;
import ast.expr.literal.*;
import ast.expr.types.*;
import ast.expr.unExpression.*;


public class EvalVisitor implements Visitor<Value> {
	
	private final Symboles symb;

	public EvalVisitor(Symboles symb) {
		this.symb = symb;
	}

	@Override
	public Value visit(Pos node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Neg node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Add node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Eq node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GEq node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GT node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LT node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Mul node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(BoolLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(IdentLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(IntLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(StrLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(BoolType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(IntType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(StrType node) {
		// TODO Auto-generated method stub
		return null;
	}

}
