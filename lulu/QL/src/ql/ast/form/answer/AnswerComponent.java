package ql.ast.form.answer;

import javax.swing.JComponent;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.Form;
import ql.ast.value.Value;

public abstract class AnswerComponent {
	public abstract JComponent getAnswerField(boolean enabled, Environment environment, Form form, Ident id);
	public abstract boolean hasValue();
	public abstract Value getAnswerValue();
	public abstract void setAnswerValue(Value value);
	public abstract void setVisible(boolean visible);
	
	protected void submitResult(Environment environment, Form form, Ident id) {
		environment.addValue(id, getAnswerValue());
		form.eval();
	}
}
