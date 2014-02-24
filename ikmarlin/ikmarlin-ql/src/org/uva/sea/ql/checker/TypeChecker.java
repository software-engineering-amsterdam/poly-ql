package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Decimal;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.ExprType;
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
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.ConditionalQuestion;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Undefined;

public class TypeChecker implements StmtVisitor, ExprVisitor {
	
	private HashMap<String, Type> symbolTable;
	public static ArrayList<String> errors;
	
	public TypeChecker(){
		this.symbolTable = new HashMap<String, Type>();
		this.errors = new ArrayList<String>();
	}
	
	public void addSymbol(Ident ident, Type type){
		this.symbolTable.put(ident.getName(), type);
	}
	
	public void addSymbol(ExprType ex, Type type){
		this.symbolTable.put(ex.toString(), type);
	}
	
	public HashMap<String, Type> getSymbolTable(){
		return this.symbolTable;
	}
	
	public void addError(String error){
		this.errors.add(error);
	}
	
	public ArrayList<String> getErrors(){
		return this.errors;
	}
	
	public HashMap<String, Type> check(Form form){
		form.getBlock().accept(this);
		return getSymbolTable();
	}
	
	@Override
	public void visit(AnswerableQuestion stmt) {
		addSymbol(stmt.getIdent(), stmt.getType().hasType());
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		Type questionType = stmt.getType().hasType();
		Type computationType = stmt.getComputation().hasType();
		stmt.getComputation().accept(this);
		addSymbol(stmt.getIdent(), questionType);
		//Check if the questions is a computable type; numeric
		if(!questionType.isCompatibleWith(new org.uva.sea.ql.ast.type.Number())){
			addError("<<"+stmt.getIdent().getName()+">> is not numeric!");
		}
		if(!computationType.isCompatibleWith(new org.uva.sea.ql.ast.type.Number())){
			addError("<<"+stmt.getComputation().toString()+">> is not numeric!");
		}
	}

	@Override
	public void visit(ConditionalQuestion stmt) {
		stmt.getCondition().accept(this);
		stmt.getBody().accept(this);
		//Check of the condition is an identifier
		if(stmt.getCondition().getClass().equals(Ident.class)){
			//Look up type
			Ident id = (Ident) stmt.getCondition();
			Type t = this.symbolTable.get(id.getName());
			//Check if it's a boolean
			if(!t.isCompatibleWith(new org.uva.sea.ql.ast.type.Bool())){
				addError("<<"+id.getName()+">> is not a boolean!");
			}
		}
	}

	@Override
	public void visit(Block stmt) {
		for (Stmt s : stmt.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(Add ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(Sub ex) {
		visitBinaryExpr(ex);
	}
	
	@Override
	public void visit(Mul ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(Div ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(And ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(Or ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(LEq ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(LT ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(NEq ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(Eq ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(GT ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(GEq ex) {
		visitBinaryExpr(ex);
	}

	@Override
	public void visit(Pos ex) {
		visitUnaryExpr(ex);
	}

	@Override
	public void visit(Neg ex) {
		visitUnaryExpr(ex);
	}

	@Override
	public void visit(Not ex) {
		visitUnaryExpr(ex);
	}

	@Override
	public void visit(Str ex) {
		visitTypeExpr(ex);
	}

	@Override
	public void visit(Bool ex) {
		visitTypeExpr(ex);
	}

	@Override
	public void visit(Int ex) {
		visitTypeExpr(ex);
	}

	@Override
	public void visit(Decimal ex) {
		visitTypeExpr(ex);
	}

	@Override
	public void visit(Money ex) {
		visitTypeExpr(ex);
	}

	@Override
	public void visit(Ident ex) {
		if(!this.symbolTable.containsKey(ex.getName())){
			addSymbol(ex, new Undefined());
			addError("<<"+ex.getName()+">> does not exist");
		}
	}
	
	private void visitBinaryExpr(Binary ex){
		ex.getLhs().accept(this);
		ex.getRhs().accept(this);
	}

	private void visitUnaryExpr(Unary ex){
		ex.getArg().accept(this);
	}

	private void visitTypeExpr(ExprType ex){
		addSymbol(ex, ex.hasType());
	}

}
