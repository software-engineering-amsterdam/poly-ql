package ql.ast.form.answer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.Form;
import ql.ast.value.Str;
import ql.ast.value.Value;

public class StrComponent extends AnswerComponent{
	private JTextField answer;
	
	@Override
	public JComponent getAnswerField(boolean enabled, final Environment environment,
			final Form form, final Ident id) {
		answer = new JTextField(30);
		answer.setEnabled(enabled);
		answer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submitResult(environment, form, id);				
			}
		});
		
		answer.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				submitResult(environment, form, id);
			}
			
			@Override
			public void focusGained(FocusEvent e) {}
		});
		return answer;
	}

	@Override
	public boolean hasValue() {
		return (!answer.getText().equals(""));
	}

	@Override
	public Value getAnswerValue() {
		return new Str(answer.getText());
	}

	@Override
	public void setAnswerValue(Value value) {
		if (value.getClass().equals(Str.class)) {
			answer.setText(((Str)value).getValue());
		}
		else {
			throw new IllegalArgumentException("The given value should be a String type");
		}
	}

	@Override
	public void setVisible(boolean visible) {
		answer.setVisible(visible);		
	}

}
