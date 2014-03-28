package ql.ast.form.stat;

import java.util.List;

import javax.swing.JPanel;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Expr;
import ql.ast.form.Form;
import ql.ast.form.FormItems;

public class IfElseStatement extends IfStatement{
	private final List<FormItems> elseBody;
	
	public IfElseStatement(Expr expr, List<FormItems> ifBody, List<FormItems> elseBody) {
		super(expr, ifBody);
		this.elseBody = elseBody;
	}
	
	public List<FormItems> getElseBody() {
		return elseBody;
	}
	
	@Override
	public boolean validate(Environment environment) {
		boolean valid = super.validate(environment);
		for (FormItems f : elseBody) {
			if (!f.validate(environment.getScopeEnvironment(f)))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}
	
	@Override
	public void buildForm(JPanel mainPanel, Environment environment, Form form) {
		super.buildForm(mainPanel, environment, form);
		for (FormItems f : elseBody) {
			f.buildForm(mainPanel, environment.getScopeEnvironment(this), form);
		}
	}
	
	@Override
	public void setVisible(Boolean visible) {
		super.setVisible(visible);
		for (FormItems f : elseBody) {
			f.setVisible(visible);
		}
	}	

	@Override
	public void eval(Environment environment) {
		setVisible(!isExprValid(environment));
		super.setVisible(isExprValid(environment));
		evalIfBody(environment);
		if (!isExprValid(environment)) {
			for (FormItems f : elseBody) {
				f.eval(environment.getScopeEnvironment(this));
			}
		}		
	}
}
