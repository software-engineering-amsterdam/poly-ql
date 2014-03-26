package ql.ast.form;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ql.ast.message.Error;
import ql.ast.environment.Environment;

public abstract class FormItems {
	protected List<Error> errors = new ArrayList<Error>();
	public abstract boolean validate(Environment environment);
	public abstract void buildForm(JPanel panel, Environment environment, Form form);
	public abstract void setVisible(Boolean visible);
	public abstract void eval(Environment environment);
	public String question;
	
	protected List<Error> getErrors(){
		return errors;
	}
	
	protected String getQuestion(){
		return question;
	}
}
