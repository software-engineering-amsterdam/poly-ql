package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Str;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.UnaryExpr;
import org.uva.sea.ql.ast.types.Type;

public class ExprChecker implements ExprVisitor<Boolean> {
	
	private final Map<Ident, Type> typeEnv;
	private final List<String> errors;
	
	private ExprChecker(Map<Ident, Type> env, List<String> errors) {
		this.typeEnv = env;
		this.errors = errors;
	}
	
	public static boolean check(Expr expr) {
		return ExprChecker.check(expr, new HashMap<Ident, Type>(), new ArrayList<String>());
	}
	
	public static boolean check(Expr expr, Map<Ident, Type> env, List<String> errors)
	{
		ExprChecker checker = new ExprChecker(env, errors);
		return expr.accept(checker);
	}

	@Override
	public Boolean visit(Add expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(And expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Bool());
	}

	@Override
	public Boolean visit(Bool expr) {
		return true;
	}

	@Override
	public Boolean visit(Div expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Eq expr) {
		return checkForCompatibleTypes(expr);
	}

	@Override
	public Boolean visit(GEq expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(GT expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Ident expr) {
		if(!this.typeEnv.containsKey(expr)) {
			this.errors.add(String.format("Identifier %s isn't defined", expr));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Int expr) {
		return true;
	}

	@Override
	public Boolean visit(LEq expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(LT expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Mul expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Neg expr) {
		return checkUnaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(NEq expr) {
		return checkForCompatibleTypes(expr);
	}

	@Override
	public Boolean visit(Not expr) {
		return checkUnaryExpr(expr, new org.uva.sea.ql.ast.types.Bool());
	}

	@Override
	public Boolean visit(Or expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Bool());
	}

	@Override
	public Boolean visit(Pos expr) {
		return checkUnaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Sub expr) {
		return checkBinaryExpr(expr, new org.uva.sea.ql.ast.types.Int());
	}

	@Override
	public Boolean visit(Str expr) {
		return true;
	}
	
	private boolean checkUnaryExpr(UnaryExpr expr, Type type) {
		if (!expr.getExpr().accept(this)) {
			return false;
		}
		
		Type exprType = expr.getExpr().typeOf(typeEnv);
		
		if (!exprType.isCompatibleTo(type)) {
			errors.add(String.format("Invalid type for operator '%s' in expression '%s': %s is of type %s",
									  expr.getSymbol(), expr, expr.getExpr(), exprType));
			return false;
		}
		
		return true;
	}
	
	private boolean checkBinaryExpr(BinaryExpr expr, Type type) {
		boolean leftTypeCorrect = expr.getLhs().accept(this);
		boolean rightTypeCorrect = expr.getRhs().accept(this);
		
		if (!leftTypeCorrect || !rightTypeCorrect) {
			return false;
		}
		
		Type leftType = expr.getLhs().typeOf(typeEnv);
		Type rightType = expr.getRhs().typeOf(typeEnv);
		
		if (!leftType.isCompatibleTo(type)) {
			errors.add(String.format("Invalid type for operator '%s' in expression '%s': %s is of type %s",
									  expr.getSymbol(), expr, expr.getLhs(), leftType));
			return false;
		}
		if (!rightType.isCompatibleTo(type)) {
			errors.add(String.format("Invalid type for operator '%s' in expression '%s': %s is of type %s",
									  expr.getSymbol(), expr, expr.getRhs(), rightType));
			return false;
		}
		
		return true;
	}
	
	private boolean checkForCompatibleTypes(BinaryExpr expr) {
		boolean leftTypeCorrect = expr.getLhs().accept(this);
		boolean rightTypeCorrect = expr.getRhs().accept(this);
		
		if (!leftTypeCorrect || !rightTypeCorrect) {
			return false;
		}
		
		Type leftType = expr.getLhs().typeOf(typeEnv);
		Type rightType = expr.getRhs().typeOf(typeEnv);
		
		if (!leftType.isCompatibleTo(rightType)) {
			errors.add(String.format("Expressions of operator '%s' have incompatible types in expression '%s': " +
									 "%s is of type %s and %s is of type %s", 
									 expr.getSymbol(), expr, expr.getLhs(), leftType, expr.getRhs(), rightType));
			return false;
		}
		
		return true;
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
