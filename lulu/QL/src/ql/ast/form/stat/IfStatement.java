package ql.ast.form.stat;

import java.util.List;

import javax.swing.JPanel;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.form.Form;
import ql.ast.form.FormItems;
import ql.ast.message.Error;
import ql.ast.type.BoolType;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class IfStatement extends Statement{
	private final Expr expr;
	private final List<FormItems> ifBody;
	
	public IfStatement(Expr expr, List<FormItems> ifBody) {
		this.expr = expr;
		this.ifBody = ifBody;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	public List<FormItems> getIfBody() {
		return ifBody;
	}

	@Override
	public boolean validate(Environment environment) {
		boolean valid = true;
		errors.addAll(expr.checkType(environment));
		if (expr.getType(environment) != null && !(expr.getType(environment).equals(new BoolType()))) {
			errors.add(new Error("Ifstatement: the expression should be a boolean type"));
		}
		for (FormItems f : ifBody) {
			if (!f.validate(environment.getScopeEnvironment(this)))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}

	@Override
	public void buildForm(JPanel panel, Environment environment, Form form) {
		for (FormItems f : ifBody) {
			f.buildForm(panel, environment.getScopeEnvironment(this), form);
		}
	}

	@Override
	public void eval(Environment environment) {
		setVisible(isExprValid(environment));
		evalIfBody(environment);		
	}
	
	@Override
	public void setVisible(Boolean visible) {
		for (FormItems f : ifBody) {
			f.setVisible(visible);
		}
	}	

	protected boolean isExprValid(Environment environment) {
		Value expressionValue = expr.eval(environment);
		return ((Bool)expressionValue).getValue();
	}
	
	protected void evalIfBody(Environment environment) {
		if (isExprValid(environment)) {
			for (FormItems f : ifBody) {
				f.eval(environment.getScopeEnvironment(this));
			}
		}
	}
}
