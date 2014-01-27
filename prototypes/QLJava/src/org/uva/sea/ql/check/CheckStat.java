package org.uva.sea.ql.check;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Answerable;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.Conditional;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.Visitor;
import org.uva.sea.ql.ast.types.Type;

import static org.uva.sea.ql.check.CheckExpr.check;

public class CheckStat implements Visitor {
	private final Map<Ident, Type> typeEnv;
	private final List<Message> errors;
	
	public CheckStat(List<Message> errors) {
		this.errors = errors;
		this.typeEnv = new HashMap<Ident, Type>();
	}

	private void addError(Stat stat, String msg) {
		errors.add(new Message(stat, msg));
	}
	
	private void defineVariable(Ident var, Type type) {
		typeEnv.put(var,  type);
	}
	
	private boolean isDefined(Ident var) {
		return typeEnv.containsKey(var);
	}
	
	private Boolean checkExpr(Expr expr) {
		return check(expr, typeEnv, errors);
	}
	
	private void checkName(Question question, Type type) {
		Ident name = question.getName();
		if (isDefined(name)) {
			if (!typeEnv.get(name).equals(type)) {
				addError(question, "duplicate definition with different type");
			}
		}
		else {
			defineVariable(name, type);
		}
	}
	
	private void checkCondition(Conditional stat) {
		Expr cond = stat.getCond();
		if (checkExpr(cond)) {
			if (!cond.typeOf(typeEnv).isCompatibleToBool()) {
				addError(stat, "condition should be of boolean type");
			}
		}
	}

	@Override
	public void visit(Computed stat) {
		checkName(stat, stat.getExpr().typeOf(typeEnv));
		if (checkExpr(stat.getExpr())) {
			if (!stat.getType().equals(stat.getExpr().typeOf(typeEnv))) {
				addError(stat, "expression type not equal to declared type");
			}
		}
	}

	@Override
	public void visit(Answerable stat) {
		checkName(stat, stat.getType());
	}

	@Override
	public void visit(IfThen stat) {
		checkCondition(stat);
		stat.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElse stat) {
		checkCondition(stat);
		stat.getBody().accept(this);
		stat.getElseBody().accept(this);
	}

	@Override
	public void visit(Block stat) {
		for (Stat s: stat.getStats()) {
			s.accept(this);
		}
	}

	
}
