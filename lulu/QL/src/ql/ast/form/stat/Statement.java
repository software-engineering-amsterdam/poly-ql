package ql.ast.form.stat;

import javax.swing.JPanel;

import ql.ast.environment.Environment;
import ql.ast.form.Form;
import ql.ast.form.FormItems;

public abstract class Statement extends FormItems{
	@Override
	public abstract boolean validate(Environment environment);
	public abstract void buildForm(JPanel panel, Environment environment, Form form);
}
