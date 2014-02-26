package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Decimal;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Money;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Str;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.Unary;

public class CyclicExprChecker implements ExprVisitor<String> {

	private List<String> dependancies;
	
	public CyclicExprChecker(){
		dependancies = new ArrayList<String>();
	}
	
	public List<String> getDependancies() {
		return dependancies;
	}

	public void setDependancies(List<String> dependancies) {
		this.dependancies = dependancies;
	}

	private void addDependancy(Ident ident){
		dependancies.add(ident.getName());
	}

	public void resetDependancies(){
		dependancies.clear();
	}

	@Override
	public String visit(Add ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Sub ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Mul ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Div ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(And ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Or ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(LEq ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(LT ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(NEq ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Eq ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(GT ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(GEq ex) {
		visitBinaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Pos ex) {
		visitUnaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Neg ex) {
		visitUnaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Not ex) {
		visitUnaryExpr(ex);
		return "";
	}

	@Override
	public String visit(Str ex) {
		return "";
	}

	@Override
	public String visit(Bool ex) {
		return "";
	}

	@Override
	public String visit(Int ex) {
		return "";
	}

	@Override
	public String visit(Decimal ex) {
		return "";
	}

	@Override
	public String visit(Money ex) {
		return "";
	}

	@Override
	public String visit(Ident ex) {
		addDependancy(ex);
		return ex.getName();
	}
	
	private String visitBinaryExpr(Binary ex){
		ex.getLhs().accept(this);
		ex.getRhs().accept(this);
		return "";
	}
	
	private String visitUnaryExpr(Unary ex){
		ex.getArg().accept(this);
		return "";
	}
}