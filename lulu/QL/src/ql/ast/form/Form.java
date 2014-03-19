package ql.ast.form;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.message.Error;

public class Form {
	
	private final Ident id;
	private List<FormItems> formItems;
	private final Environment environment;
	private JFrame frame;
	
	public Form(Ident id, List<FormItems> formItems){
		this.id = id;
		this.formItems = formItems;
		this.environment = new Environment();
	}
	
	public List<FormItems> getFormItems() {
		return formItems;
	}
	
	public String getIdent() {
		return id.getValue();
	}
	
	public Environment getEnvironment() {
		return environment;
	}
	
	public boolean validate() {
		boolean valid = true;
		for (FormItems f : formItems) {
			valid &= f.validate(environment);
		}
		return valid;
	}
	
	public String getError() {
		String errorText = "Form: " + id + "\n";
		for (FormItems f : formItems) {
			for(Error err : f.getErrors())
				errorText += err.getText() + "\n";
		}
		return errorText;
	}

	public JPanel buildForm(JFrame frame) {
		this.frame = frame;
		JPanel panel = new JPanel(new MigLayout("hidemode 3"));
		for (FormItems f : formItems) {
			f.buildForm(panel, environment, this);
		}
		eval();
		return panel;
	}
	
	public void eval() {
		for (FormItems f : formItems) {
			f.eval(environment);
		}
		frame.pack();
	}
}
