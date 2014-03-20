package org.uva.sea.ql.checker.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.Unary;
import org.uva.sea.ql.ast.type.Null;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.exception.error.Error;
import org.uva.sea.ql.checker.exception.error.IllegalArithmeticError;
import org.uva.sea.ql.checker.exception.error.IllegalBooleanError;
import org.uva.sea.ql.checker.exception.error.IncompatibleTypesError;

public class ExprVisitorType implements IExprVisitor<Type> {
	
	private Map<String, Type> symbolTable;
	private List<Error> errors;

	public ExprVisitorType(Map<String, Type> symbolTable){
		this.symbolTable = symbolTable;
		this.errors = new ArrayList<Error>();
	}
	
	public Type addError(Error err){
		errors.add(err);
		return new Null();
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public List<Error> getErrors(){
		return errors;
	}
	
	private Type visitEquality(Binary ex) {
		Type lhs = ex.getLhs().accept(this);
		Type rhs = ex.getRhs().accept(this);
		if(!rhs.isCompatibleWith(lhs)){
			return addError(new IncompatibleTypesError(ex.getLhs(), lhs, ex.getRhs(), rhs));
		}
		return ex.hasType();
	}

	private Type visitComparison(Binary ex) {
		Type lhs = ex.getLhs().accept(this);
		Type rhs = ex.getRhs().accept(this);
		if (!lhs.isCompatibleWithNumber()) {
			return addError(new IllegalArithmeticError(ex.getLhs(), lhs));
		}
		if (!rhs.isCompatibleWithNumber()) {
			return addError(new IllegalArithmeticError(ex.getRhs(), rhs));
		}
		return ex.hasType();
	}

	private Type visitBinaryBoolean(Binary ex) {
		Type lhs = ex.getLhs().accept(this);
		Type rhs = ex.getRhs().accept(this);
		if (!lhs.isCompatibleWithBool()) {
			return addError(new IllegalBooleanError(ex.getLhs(), lhs));
		}
		if (!rhs.isCompatibleWithBool()) {
			return addError(new IllegalBooleanError(ex.getRhs(), rhs));
		}
		return ex.hasType();
	}

	private Type visitUnaryBoolean(Unary ex) {
		Type arg = ex.getArg().accept(this);
		if (!arg.isCompatibleWithBool()) {
			return addError(new IllegalBooleanError(ex.getArg(), arg));
		}
		return ex.hasType();
	}

	private Type visitBinaryArithmetic(Binary ex) {
		Type lhs = ex.getLhs().accept(this);
		Type rhs = ex.getRhs().accept(this);
		if (!lhs.isCompatibleWithNumber()) {
			return addError(new IllegalArithmeticError(ex.getLhs(), lhs));
		}
		if (!rhs.isCompatibleWithNumber()) {
			return addError(new IllegalArithmeticError(ex.getRhs(), rhs));
		}
		return ex.hasType();
	}

	private Type visitUnaryArithmetic(Unary ex) {
		Type arg = ex.getArg().accept(this);
		if (!arg.isCompatibleWithNumber()) {
			return addError(new IllegalArithmeticError(ex.getArg(), arg));
		}
		return ex.hasType();
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
	public Type visit(GT ex) {
		return visitComparison(ex);
	}

	@Override
	public Type visit(GEq ex) {
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
	public Type visit(Ident ex) {
		return ex.getType(symbolTable);
	}

	@Override
	public Type visit(BoolLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(StrLiteral ex) {
		return ex.hasType();
	}

	@Override
	public Type visit(IntLiteral ex) {
		return ex.hasType();
	}

}
