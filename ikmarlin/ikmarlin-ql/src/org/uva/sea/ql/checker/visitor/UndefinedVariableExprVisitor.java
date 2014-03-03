package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.DecimalLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Literal;
import org.uva.sea.ql.ast.expr.MoneyLiteral;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.Unary;

public class UndefinedVariableExprVisitor implements IExprVisitor<List<Ident>> {

	private List<Ident> variables;
	private boolean isExpr;
	
	public UndefinedVariableExprVisitor(){
		variables = new ArrayList<Ident>();
	}
	
	public void resetVariables(){
		variables.clear();
	}

	private List<Ident> visitBinaryExpr(Binary ex){
		isExpr = true;
		ex.getLhs().accept(this);
		ex.getRhs().accept(this);
		isExpr = false;
		return variables;
	}

	private List<Ident> visitUnaryExpr(Unary ex){
		isExpr = true;
		ex.getArg().accept(this);
		isExpr = false;
		return variables;
	}

	private List<Ident> visitLiteral(Literal<?> ex){
		return null;
	}

	@Override
	public List<Ident> visit(Ident ex) {
		if(isExpr){
			variables.add(ex);
		}
		return variables;
	}

	@Override
	public List<Ident> visit(Add ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Sub ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Mul ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Div ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(And ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Or ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(LEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(LT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(NEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Eq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(GT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(GEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Pos ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Neg ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public List<Ident> visit(Not ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public List<Ident> visit(BoolLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public List<Ident> visit(StrLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public List<Ident> visit(DecimalLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public List<Ident> visit(IntLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public List<Ident> visit(MoneyLiteral ex) {
		return visitLiteral(ex);
	}
	
}