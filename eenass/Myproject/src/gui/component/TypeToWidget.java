package gui.component;

import ast.Visitor;
import ast.expr.Identifier;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.And;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Eq;
import ast.expr.binExpr.GEq;
import ast.expr.binExpr.GT;
import ast.expr.binExpr.LEq;
import ast.expr.binExpr.LT;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.NEq;
import ast.expr.binExpr.Or;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.StatementList;
import ast.types.BoolType;
import ast.types.IntType;
import ast.types.StrType;

public class TypeToWidget implements Visitor<Widget> {
	
	public TypeToWidget(){
		
	}
	
	@Override
	public Widget visit(BoolType node) {
		return new CheckBox();
	}

	@Override
	public Widget visit(IntType node) {
		return new TextField();
	}

	@Override
	public Widget visit(StrType node) {
		return new TextField();
	}

	@Override
	public Widget visit(Pos node) {
		return null;
	}

	@Override
	public Widget visit(Neg node) {
		return null;
	}

	@Override
	public Widget visit(Not node) {
		return null;
	}

	@Override
	public Widget visit(Add node) {
		return null;
	}

	@Override
	public Widget visit(And node) {
		return null;
	}

	@Override
	public Widget visit(Div node) {
		return null;
	}

	@Override
	public Widget visit(Eq node) {
		return null;
	}

	@Override
	public Widget visit(GEq node) {
		return null;
	}

	@Override
	public Widget visit(GT node) {
		return null;
	}

	@Override
	public Widget visit(LEq node) {
		return null;
	}

	@Override
	public Widget visit(LT node) {
		return null;
	}

	@Override
	public Widget visit(Mul node) {
		return null;
	}

	@Override
	public Widget visit(NEq node) {
		return null;
	}

	@Override
	public Widget visit(Or node) {
		return null;
	}

	@Override
	public Widget visit(Sub node) {
		return null;
	}

	@Override
	public Widget visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Widget visit(Identifier node) {
		return null;
	}

	@Override
	public Widget visit(IntLiteral node) {
		return null;
	}

	@Override
	public Widget visit(StrLiteral node) {
		return null;
	}

	@Override
	public Widget visit(StatementList node) {
		return null;
	}

	@Override
	public Widget visit(Question node) {
		return null;
	}

	@Override
	public Widget visit(ComputedQuestion node) {
		return null;
	}

	@Override
	public Widget visit(Block node) {
		return null;
	}

	@Override
	public Widget visit(IfStatement node) {
		return null;
	}

	@Override
	public Widget visit(IfelseStatement node) {
		return null;
	}

	@Override
	public Widget visit(Form node) {
		return null;
	}
	

}
