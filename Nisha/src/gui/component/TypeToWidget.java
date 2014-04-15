package gui.component;

import ast.Visitor;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.StatementList;
import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
import expr.Ident;
import expr.conditional.And;
import expr.conditional.Or;
import expr.operation.Add;
import expr.operation.Div;
import expr.operation.Mul;
import expr.operation.Sub;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.unary.Neg;
import expr.unary.Not;
import expr.unary.Pos;
import gui.render.State;

public class TypeToWidget implements Visitor<Control> {

	String description;
	Ident id;
	Form form;
	State state;
	public TypeToWidget(String description, Ident id, Form form, State state){
		this.description=description;
		this.id=id;
		this.form=form;
		this.state=state;
		

	}

	@Override
	public Control visit(Booltype node) {
		return new CheckBox(description, id, form, state);
	}

	@Override
	public Control visit(Inttype node) {
		return new TextField(description, id);
	}

	@Override
	public Control visit(Strtype node) {
		return new TextField(description, id);
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
	public Control visit(Ident node) {
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
	public Control visit(Computedquest node) {
		return null;
	}

	@Override
	public Control visit(Block node) {
		return null;
	}

	@Override
	public Control visit(Ifstate node) {
		return null;
	}

	@Override
	public Control visit(IfElse node) {
		return null;
	}

	@Override
	public Control visit(Form node) {
		return null;
	}




}