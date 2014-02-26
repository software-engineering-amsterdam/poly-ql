package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.DecimalLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
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
import org.uva.sea.ql.ast.type.Error;
import org.uva.sea.ql.ast.type.Type;

public class ExprChecker implements ExprVisitor<Type> {

	private HashMap<String, Type> symbolTable;
	private List<Error> errors;

	public ExprChecker(HashMap<String, Type> symbolTable) {
		this.setSymbolTable(symbolTable);
		setErrors(new ArrayList<Error>());
	}

	public HashMap<String, Type> getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(HashMap<String, Type> symbolTable) {
		this.symbolTable = symbolTable;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	private void addError(Error err){
		errors.add(err);
	}

	public void resetErrors(){
		errors.clear();
	}

	public Type infer(Expr ex) {
		return ex.accept(this);
	}

	@Override
	public Type visit(Add ex) {
		return visitBinaryArithmetic(ex);
	}

	@Override
	public Type visit(Sub ex) {
		return visitBinaryArithmetic(ex);
	}

	@Override
	public Type visit(Mul ex) {
		return visitBinaryArithmetic(ex);
	}

	@Override
	public Type visit(Div ex) {
		return visitBinaryArithmetic(ex);
	}

	@Override
	public Type visit(And ex) {
		return visitBinaryBoolean(ex);
	}

	@Override
	public Type visit(Or ex) {
		return visitBinaryBoolean(ex);
	}

	@Override
	public Type visit(LEq ex) {
		return visitComparison(ex);
	}

	@Override
	public Type visit(LT ex) {
		return visitComparison(ex);
	}

	@Override
	public Type visit(NEq ex) {
		return visitEquality(ex);
	}

	@Override
	public Type visit(Eq ex) {
		return visitEquality(ex);
	}

	@Override
	public Type visit(GT ex) {
		return visitComparison(ex);
	}

	@Override
	public Type visit(GEq ex) {
		return visitComparison(ex);
	}

	@Override
	public Type visit(Pos ex) {
		return visitUnaryArithmetic(ex);
	}

	@Override
	public Type visit(Neg ex) {
		return visitUnaryArithmetic(ex);
	}

	@Override
	public Type visit(Not ex) {
		return visitUnaryBoolean(ex);
	}

	@Override
	public Type visit(StrLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(BoolLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(IntLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(DecimalLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(MoneyLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(Ident ex) {
		if (symbolTable.containsKey(ex.getName())) {
			return symbolTable.get(ex.getName());
		} else {
			Error error = new Error("the question << "+ex+" >> does not exist.");
			addError(error);
			return error;
		}
	}

	private Type visitEquality(Binary ex) {
		ex.getLhs().accept(this);
		ex.getRhs().accept(this);
		return new org.uva.sea.ql.ast.type.Bool();
	}

	private Type visitBinaryBoolean(Binary ex) {
		Type expected = new org.uva.sea.ql.ast.type.Bool();
		Type l = ex.getLhs().accept(this);
		Type r = ex.getRhs().accept(this);
		if (!l.isCompatibleWithBool()) {
			return getError(ex.getLhs(), l, expected);
		}
		if (!r.isCompatibleWithBool()) {
			return getError(ex.getRhs(), r, expected);
		}
		return expected;
	}

	private Type visitUnaryBoolean(Unary ex) {
		Type expected = new org.uva.sea.ql.ast.type.Bool();
		Type arg = ex.getArg().accept(this);
		if (!arg.isCompatibleWithBool()) {
			return getError(ex.getArg(), arg, expected);
		}
		return expected;
	}

	private Type visitComparison(Binary ex) {
		Type expected = new org.uva.sea.ql.ast.type.Bool();
		Type l = ex.getLhs().accept(this);
		Type r = ex.getRhs().accept(this);
		if (!l.isCompatibleWithNumber()) {
			return getError(ex.getLhs(), l, expected);
		}
		if (!r.isCompatibleWithNumber()) {
			return getError(ex.getRhs(), r, expected);
		}
		return expected;
	}

	private Type visitBinaryArithmetic(Binary ex) {
		Type expected = new org.uva.sea.ql.ast.type.Number();
		Type l = ex.getLhs().accept(this);
		Type r = ex.getRhs().accept(this);
		if (!l.isCompatibleWithNumber()) {
			return getError(ex.getLhs(), l, expected);
		}
		if (!r.isCompatibleWithNumber()) {
			return getError(ex.getRhs(), r, expected);
		}
		return expected;
	}

	private Type visitUnaryArithmetic(Unary ex) {
		Type expected = new org.uva.sea.ql.ast.type.Number();
		Type arg = ex.getArg().accept(this);
		if (!arg.isCompatibleWithNumber()) {
			return getError(ex.getArg(), arg, expected);
		}
		return expected;
	}

	private Error getError(Expr ex, Type given, Type expected) {
		String msg = "the expression << " + ex + " >> is ";
		if(!(given instanceof Error)){
			msg += "a(n) " + given +", ";
		}
		msg += "not a(n) " + expected + ".";
		Error err = new Error(msg);
		addError(err);
		return err;
	}

}
