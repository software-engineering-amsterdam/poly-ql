package org.uva.sea.ql.check;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
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
import org.uva.sea.ql.ast.expr.Visitor;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;

public class CheckExpr implements Visitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<Message> messages;
	
	private CheckExpr(Map<Ident, Type> tenv, List<Message> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<Message> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	private static String opErrorMessage(String op, Type type) {
		return op + " requires " + type + " type for arguments";
	}
	
	private void addError(Expr expr, String msg) {
		messages.add(new Message(expr, msg));
	}

	private boolean check(Expr expr, Type type, String op, Expr ...args) {
		if (!checkArgs(args)) {
			return false;
		}
		for (Expr x: args) {
			if (!type.isCompatibleTo(x.typeOf(typeEnv))) {
				addError(expr, opErrorMessage(op, type));
				return false;
			}
		}
		return true;
	}
	
	private boolean checkNumeric(Expr expr, String op, Expr ...args) {
		return check(expr, new Numeric(), op, args);
	}
	
	private boolean checkBool(Expr expr, String op, Expr ...args) {
		return check(expr, new Bool(), op, args);
	}

	private boolean checkArgs(Expr... args) {
		boolean argsOk = true;
		for (Expr x: args) {
			argsOk &= x.accept(this);
		}
		return argsOk;
	}
	
	
	private Boolean checkEqual(Expr expr, String op, Expr lhs, Expr rhs) {
		if (!checkArgs(lhs, rhs)) {
			return false;
		}
		Type t1 = lhs.typeOf(typeEnv);
		Type t2 = rhs.typeOf(typeEnv);
		if (!t1.isCompatibleTo(t2)) {
			addError(expr, op + " requires compatible types");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Add ast) {
		return checkNumeric(ast, "+", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(And ast) {
		return checkBool(ast, "&&", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Div ast) {
		return checkNumeric(ast, "/", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Eq ast) {
		return checkEqual(ast, "==", ast.getLhs(), ast.getRhs());
	}

	
	@Override
	public Boolean visit(GEq ast) {
		return checkNumeric(ast, ">=", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(GT ast) {
		return checkNumeric(ast, ">", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Ident ast) {
		if (!typeEnv.containsKey(ast)) {
			addError(ast, "undefined identifier");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		return checkNumeric(ast, "<=", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(LT ast) {
		return checkNumeric(ast, "<", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Mul ast) {
		return checkNumeric(ast, "*", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Neg ast) {
		return checkNumeric(ast, "unary -", ast.getArg());
	}

	@Override
	public Boolean visit(NEq ast) {
		return checkEqual(ast, "!=", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Not ast) {
		return checkBool(ast, "!", ast.getArg());
	}

	@Override
	public Boolean visit(Or ast) {
		return checkBool(ast, "||", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(Pos ast) {
		return checkNumeric(ast, "unary +", ast.getArg());
	}

	@Override
	public Boolean visit(Sub ast) {
		return checkNumeric(ast, "-", ast.getLhs(), ast.getRhs());
	}

	@Override
	public Boolean visit(org.uva.sea.ql.ast.expr.Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(Str str) {
		return true;
	}

}
