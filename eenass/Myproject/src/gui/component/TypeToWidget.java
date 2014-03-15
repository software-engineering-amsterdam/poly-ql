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
import ast.expr.types.BoolType;
import ast.expr.types.IntType;
import ast.expr.types.StrType;
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

public class TypeToWidget implements Visitor<Control> {
	
	public TypeToWidget(){
		
	}
	
	@Override
	public Control visit(BoolType node) {
		return new CheckBox();
	}

	@Override
	public Control visit(IntType node) {
		return new TextField();
	}

	@Override
	public Control visit(StrType node) {
		return new TextField();
	}

	@Override
	public Control visit(Pos node) {
		return null;
	}

	@Override
	public Control visit(Neg node) {
		return null;
	}

	@Override
	public Control visit(Not node) {
		return null;
	}

	@Override
	public Control visit(Add node) {
		return null;
	}

	@Override
	public Control visit(And node) {
		return null;
	}

	@Override
	public Control visit(Div node) {
		return null;
	}

	@Override
	public Control visit(Eq node) {
		return null;
	}

	@Override
	public Control visit(GEq node) {
		return null;
	}

	@Override
	public Control visit(GT node) {
		return null;
	}

	@Override
	public Control visit(LEq node) {
		return null;
	}

	@Override
	public Control visit(LT node) {
		return null;
	}

	@Override
	public Control visit(Mul node) {
		return null;
	}

	@Override
	public Control visit(NEq node) {
		return null;
	}

	@Override
	public Control visit(Or node) {
		return null;
	}

	@Override
	public Control visit(Sub node) {
		return null;
	}

	@Override
	public Control visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Control visit(Identifier node) {
		return null;
	}

	@Override
	public Control visit(IntLiteral node) {
		return null;
	}

	@Override
	public Control visit(StrLiteral node) {
		return null;
	}

	@Override
	public Control visit(StatementList node) {
		return null;
	}

	@Override
	public Control visit(Question node) {
		return null;
	}

	@Override
	public Control visit(ComputedQuestion node) {
		return null;
	}

	@Override
	public Control visit(Block node) {
		return null;
	}

	@Override
	public Control visit(IfStatement node) {
		return null;
	}

	@Override
	public Control visit(IfelseStatement node) {
		return null;
	}

	@Override
	public Control visit(Form node) {
		return null;
	}
	

}
